package ru.MoVe.SSK_bot.logic;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.MoVe.SSK_bot.AnswerWriter;

public class Bot extends TelegramLongPollingBot implements AnswerWriter {
    // создаем две константы, присваиваем им значения токена и имя бота соответственно
    private static final String BOT_TOKEN = "6425872456:AAEcpNhm_8efu23sNm0yWFyNvJnVtgJnETQ";
    private static final String BOT_NAME = "SSK_bot";

    public String getBotToken() {
        return BOT_TOKEN;
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String messageText = message.getText();
            String chatId = message.getChatId().toString();

            BotRequest request = new BotRequest(messageText, chatId);
            new Handler().handle(request, this);
        }
    }

    /**
     * Отправка ответного сообщения в чат
     */
    @Override
    public void writeAnswer(BotResponse response) {
        SendMessage message = new SendMessage(response.getResponseID(), response.getResponseText());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
