package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Start implements Command {
    private final static String id = "/start";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                Здравствуй, студент!
                Бот Совета Студенческих Корпусов (ССК) поможет тебе узнать основную информацию об общежитии.
                Помощь по функционалу —> /help""";
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
