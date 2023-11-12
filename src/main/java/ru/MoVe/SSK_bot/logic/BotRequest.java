package ru.MoVe.SSK_bot.logic;

/**
 * Класс-запрос пользователя
 */
public class BotRequest {
    private final String requestText;
    private final String requestID;
    private final boolean buttonPressed;
    private final String callData;

    public BotRequest(String data, String id, boolean buttonPressed, String callData) {
        this.requestText = data;
        this.requestID = id;
        this.buttonPressed = buttonPressed;
        this.callData = callData;
    }

    public String getRequestText() {
        return requestText;
    }
    public String getRequestID() {
        return requestID;
    }
    public boolean isButtonPressed() {
        return buttonPressed;
    }
    public String getCallData() {
        return callData;
    }
}