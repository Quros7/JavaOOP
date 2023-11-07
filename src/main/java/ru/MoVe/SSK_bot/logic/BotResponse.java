package ru.MoVe.SSK_bot.logic;

public class BotResponse {
    /**
     * response to user's request
     */
    private String responseText;
    private final String responseID;

    public BotResponse(String data, String id) {
        this.responseText = data;
        this.responseID = id;
    }

    public String getResponseText() {
        return responseText;
    }

    public String getResponseID() {
        return responseID;
    }

    public void setResponseText(String data) {
        this.responseText = data;
    }
}
