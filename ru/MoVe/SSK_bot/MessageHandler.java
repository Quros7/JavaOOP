package ru.MoVe.SSK_bot;
import ru.MoVe.SSK_bot.console.BotRequest;

public interface MessageHandler {
    void handle(BotRequest request, AnswerWriter writer);
}
