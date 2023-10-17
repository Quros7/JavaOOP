package ru.MoVe.SSK_bot.telegram;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.MoVe.SSK_bot.logic.BotRequest;

public class UpdateToRequest {
    Message message;
    String messageText;
    String chatId;
    public BotRequest CreateRequest(Update update) {
        message = update.getMessage();
        messageText = message.getText();
        chatId = message.getChatId().toString();

        return new BotRequest(messageText, chatId);
    }
}
