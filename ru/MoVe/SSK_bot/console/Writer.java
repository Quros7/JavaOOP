package ru.MoVe.SSK_bot.console;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.logic.BotResponse;

public class Writer implements AnswerWriter {
    public void writeAnswer(BotResponse response) {
        System.out.println(response.getResponseText());
    }
}
