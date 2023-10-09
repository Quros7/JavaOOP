package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.MessageHandler;

public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        BotResponse answer = new BotResponse(request.getRequestText());
        writer.writeAnswer(answer);
    }
}
