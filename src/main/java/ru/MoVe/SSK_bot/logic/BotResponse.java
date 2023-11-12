package ru.MoVe.SSK_bot.logic;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Класс-ответ на сообщение
 */
public class BotResponse {
    private final String responseText;
    private final String responseID;
    private InlineKeyboardMarkup keyboard;

    public BotResponse(String data, String id) {
        this.responseText = data;
        this.responseID = id;
    }
    public BotResponse(String data, String id, InlineKeyboardMarkup keyboard) {
        this.responseText = data;
        this.responseID = id;
        this.keyboard = keyboard;
    }
    public String getResponseText() {
        return responseText;
    }

    public String getResponseID() {
        return responseID;
    }

    public InlineKeyboardMarkup getInlineKeyboardMarkup() {
        return keyboard;
    }
}
