package ru.MoVe.SSK_bot.logic;

public class BotResponse {
    /**
     * response to user's request
     */
    private String responseText;

    public BotResponse(String data) {
        this.responseText = data;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String data) {
        this.responseText = data;
    }
}
