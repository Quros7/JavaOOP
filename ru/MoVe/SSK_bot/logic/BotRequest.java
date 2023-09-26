package ru.MoVe.SSK_bot.logic;

public class BotRequest {
    private String requestText; // user's message text
    public BotRequest(String data) {
        this.requestText = data;
    }
    public String getRequestText() {
        return requestText;
    };
}
