package ru.MoVe.SSK_bot.telegram;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.MoVe.SSK_bot.logic.BotRequest;

/**
 * Класс, "переводящий" update Telegram-а в наш класс BotRequest
 */
public class UpdateToBotRequest {
    /**
     * Метод, который "переводит" update Telegram-а в наш класс BotRequest
    **/
    public BotRequest CreateRequest(Update update) {
        String messageText = null;
        String chatId = null;

        if(update.hasMessage()) {
            Message message = update.getMessage();
            messageText = message.getText().trim();
            chatId = message.getChatId().toString();
        }
        else if(update.hasCallbackQuery()){
            messageText = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        }
        return new BotRequest(messageText, chatId);
    }
}
