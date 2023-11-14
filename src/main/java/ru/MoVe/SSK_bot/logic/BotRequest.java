package ru.MoVe.SSK_bot.logic;

/**
 * Класс-запрос пользователя
 */
public class BotRequest {
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
}