package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class cd_Studyroom implements Command {
    private final static String id = "studyroom";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                В общежитии есть читальный зал, в котором вы можете
                позаниматься учебой или просто посидеть в тихой обстановке.
                
                <i>Если он открыт, то заходите и пользуйтесь.
                Если же закрыт, то обратитесь на пост охраны и вежливо! попросите ключ от читального зала,
                оставив взамен свой пропуск или студенческий билет</i>
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
