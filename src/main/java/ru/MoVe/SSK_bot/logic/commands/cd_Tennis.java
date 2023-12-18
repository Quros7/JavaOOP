package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class cd_Tennis implements Command {
    private final static String id = "tennis";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                В общежитии есть теннисный зал, в котором вы можете
                поиграть в теннис, занять диванчик, чтобы позаниматься учёбой или отдохнуть,
                или вы можете потренироваться перед зеркалами
                на дальней от входа стене комнаты.
                
                <i>Если зал открыт, то заходите и пользуйтесь.
                Если же закрыт, то обратитесь на пост охраны и вежливо! попросите ключ от теннисного зала,
                оставив взамен свой пропуск или студенческий билет.</i>
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
