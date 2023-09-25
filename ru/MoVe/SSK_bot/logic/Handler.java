package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.MessageHandler;
import ru.MoVe.SSK_bot.console.BotRequest;
import ru.MoVe.SSK_bot.console.BotResponse;

public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        BotResponse ans = new BotResponse();
        ans.changeResponse(request.getTextData());
        writer.writeAnswer(ans);
    }
}
