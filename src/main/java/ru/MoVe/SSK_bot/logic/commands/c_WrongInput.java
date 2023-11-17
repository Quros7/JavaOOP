package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

public class c_WrongInput implements Command {
    private final static String id = "wrongInput";
    @Override
    public boolean needExecute(BotRequest request) {
        return false;
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = "Неверный ввод.";
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
        c_Help help = new c_Help();
        help.execute(request, writer);
    }
}
