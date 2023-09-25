package ru.MoVe.SSK_bot.console;

import ru.MoVe.SSK_bot.AnswerWriter;

public class BotResponse implements AnswerWriter {
    String responseText;
    public void mutate(String data) {
        this.responseText = data;
    }
    public void writeAnswer(BotResponse response) {
        System.out.println(response.responseText);
    }
}
