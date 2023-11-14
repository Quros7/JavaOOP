package ru.MoVe.SSK_bot.logic;
/**
 * Класс-ответ на сообщение
 */
public class BotResponse {
    private final String responseText;
    private final String responseID;
    private final boolean hasKeyboard;
    //private final String commandCalledKeyboard;

    public BotResponse(String data, String id) {
        this.responseText = data;
        this.responseID = id;
        hasKeyboard = false;
    }
    public BotResponse(String data, String id, boolean hasKeyboard) {
        this.responseText = data;
        this.responseID = id;
        this.hasKeyboard = hasKeyboard;
    }
    public String getResponseText() {
        return responseText;
    }

    public String getResponseID() {
        return responseID;
    }

    public boolean hasKeyboard() {
        return hasKeyboard;
    }
}
