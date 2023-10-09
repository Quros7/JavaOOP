package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.console.Reader;
import ru.MoVe.SSK_bot.console.Writer;

public class Main {
    public static void main (String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        Handler handler = new Handler();

        BotRequest message = reader.getUserInput();

        while (!message.isStopMessage()) {
            handler.handle(message, writer);
            message = reader.getUserInput();
        }
    }
}
