package ru.MoVe.SSK_bot.logic;

public class BotRequest {
    /**
     * user's message text
     */
    private final String requestText;

    public BotRequest(String data) {
        this.requestText = data;
    }

    public String getRequestText() {
        return requestText;
    };

    public boolean isStopMessage() {
        return requestText.equals("/break");
    }
}
