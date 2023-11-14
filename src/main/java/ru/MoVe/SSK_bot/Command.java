package ru.MoVe.SSK_bot;

import ru.MoVe.SSK_bot.logic.BotRequest;

public interface Command {
    boolean needExecute(BotRequest request);
    void execute(BotRequest request, AnswerWriter writer);
}
