package ru.MoVe.SSK_bot.console;

import ru.MoVe.SSK_bot.AnswerWriter;

public class BotResponse implements AnswerWriter {
    String responseText;
    public void writeAnswer(BotResponse response) {
        System.out.println(response.responseText);
    }
}
