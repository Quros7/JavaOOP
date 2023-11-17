package ru.MoVe.SSK_bot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;
import ru.MoVe.SSK_bot.logic.Handler;
import ru.MoVe.SSK_bot.logic.commands.*;

import java.util.List;

public class Bot extends TelegramLongPollingBot implements AnswerWriter {
    private static final String BOT_TOKEN = "6425872456:AAEcpNhm_8efu23sNm0yWFyNvJnVtgJnETQ";
    private static final String BOT_NAME = "SSK_bot";

    public final String getBotToken() {
        return BOT_TOKEN;
    }

    public final String getBotUsername() {
        return BOT_NAME;
    }

    private final UpdateToBotRequest updateToBotRequest = new UpdateToBotRequest();

    private final c_Start start = new c_Start();
    private final c_Info info = new c_Info();
    private final c_Contacts contacts = new c_Contacts();
    private final c_Events events = new c_Events();
    private final c_Feedback feedback = new c_Feedback();
    private final c_Help help = new c_Help();
    private final cd_Guests guests = new cd_Guests();
    private final cd_Internet internet = new cd_Internet();
    private final cd_Tennis tennis = new cd_Tennis();
    private final cd_Studyroom studyroom = new cd_Studyroom();

    private final Handler handler = new Handler(List.of(start, info, contacts, events, feedback,
            help, guests, internet, tennis, studyroom));

    @Override
    public void onUpdateReceived(Update update) {
        BotRequest request = updateToBotRequest.CreateRequest(update);
        handler.handle(request, this);
        if (update.hasCallbackQuery()) {
            closeCallbackQuery(update);
        }
    }

    /**
     * Фунция, отправляющая сообщение в чат
     */
    @Override
    public void writeAnswer(BotResponse response) {
        SendMessage message = SendMessage.builder()
                .chatId(response.getResponseID())
                .text(response.getResponseText())
                .parseMode("HTML").build();

        if(response.hasKeyboard()){
             message.setReplyMarkup(createKeyboard());
        }
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
          * Функцция, создающая клавиатура для ответа на команду /info
          * @return InlineKeyboardMarkup
          */
    private InlineKeyboardMarkup createKeyboard(){
        var guests = InlineKeyboardButton.builder()
                .text("Правила посещения общежития гостями").callbackData("guests")
                .build();
        var internet = InlineKeyboardButton.builder()
                .text("Об интернете").callbackData("internet")
                .build();
        var tennis = InlineKeyboardButton.builder()
                .text("Теннисный зал").callbackData("tennis")
                .build();
        var studyRoom = InlineKeyboardButton.builder()
                .text("Учебный зал").callbackData("studyroom")
                .build();

        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(guests))
                .keyboardRow(List.of(internet))
                .keyboardRow(List.of(tennis))
                .keyboardRow(List.of(studyRoom))
                .build();
    }

    /**
     * Метод, закрывающий CallbackQuery в чате
     * @param update Telegram update
     */
    private void closeCallbackQuery(Update update) {
        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(update.getCallbackQuery().getId()).build();
        try {
            execute(close);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
