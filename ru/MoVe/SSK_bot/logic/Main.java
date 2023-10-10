package ru.MoVe.SSK_bot.logic;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.MoVe.SSK_bot.console.Reader;
import ru.MoVe.SSK_bot.console.Writer;

public class Main {
    public static void main (String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        // следующая часть не используется
        // TODO: функционал бота на основе старых классов?
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
