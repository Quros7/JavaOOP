package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.console.BotRequest;
import ru.MoVe.SSK_bot.console.BotResponse;

public class Main {
    public static void main (String[] args) {
        BotRequest msg = new BotRequest();
        msg = msg.getUserInput();
        Handler hl = new Handler();
        BotResponse rsp = new BotResponse();
        while (!msg.getTextData().equals("break")) {
            hl.handle((BotRequest)msg, rsp);
            msg = msg.getUserInput();
        }
    }
}
