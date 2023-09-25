package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.console.BotRequest;
import ru.MoVe.SSK_bot.console.BotResponse;

public class Handler {
    public void handle (BotRequest request, AnswerWriter writer) {
        BotResponse ans = new BotResponse();
        ans.mutate(request.getTextData());
        writer.writeAnswer(ans);
    }
}
