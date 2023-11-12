package ru.MoVe.SSK_bot.telegram;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.MoVe.SSK_bot.logic.BotRequest;

/**
 * Класс, "переводящий" update Telegram-а в наш класс BotRequest
 */
public class UpdateToBotRequest {
    Message message;
    String messageText;
    String chatId;
    /**
     * Переменная, отображающая был update вызван нажатием кнопки или отправкой сообщения от пользователя
     */
    boolean buttonPressed;
    String callData = null;
    /**
     * Метод, который "переводит" update Telegram-а в наш класс BotRequest
    **/
    public BotRequest CreateRequest(Update update) {
        if(update.hasMessage()) {
            message = update.getMessage();
            messageText = message.getText();
            chatId = message.getChatId().toString();
        }
        else if(update.hasCallbackQuery()){
            buttonPressed = update.hasCallbackQuery();
            callData = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getMessage().getChatId().toString();
//            AnswerCallbackQuery close = AnswerCallbackQuery.builder()
//                    .callbackQueryId(update.getCallbackQuery().getId()).build();
            //TODO:РАЗОБРАТЬСЯ, КАК ЗА-EXECUTE-ИТЬ AnswerCallbackQuery
        }
        return new BotRequest(messageText, chatId, buttonPressed, callData);
    }
}
