package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;

public class BotResponse {
    private String responseText;
    public BotResponse(String data) {
        this.responseText = data;
    }
    public String getResponseText() {
        return responseText;
    }
    public void changeResponse(String data) {
        this.responseText = data;
    }
}
