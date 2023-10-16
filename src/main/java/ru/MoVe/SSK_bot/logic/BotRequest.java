package ru.MoVe.SSK_bot.logic;

public class BotRequest {
    /**
     * user's message text
     */
    private final String requestText;
    private final String requestID;

    public BotRequest(String data, String id) {
        this.requestText = data;
        this.requestID = id;
    }

    public String getRequestText() {
        return requestText;
    }
    public String getRequestID() {
        return requestID;
    }

    public boolean isStopMessage() {
        return requestText.equals("/break");
    }
}
