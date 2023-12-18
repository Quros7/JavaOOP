package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class cd_Guests implements Command {
    private final static String id = "guests";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                Жильцы могут приводить гостей.
                Им можно приходить с 8:00, но они обязательно должны уйти до 22:00.
                (Иначе больше к вам никого не допустят :) )
                Чтобы гости попали в общежитие, вы должны оставить на посту охраны:
                   • свой электронный пропуск
                   • документ гостя (любой, кроме паспорта)
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
