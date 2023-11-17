package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.MessageHandler;
import ru.MoVe.SSK_bot.logic.commands.c_WrongInput;

import java.util.List;

/**
 * Класс, обрабатывающий запрос пользователя
 */
public class Handler implements MessageHandler {
    private final List<Command> commands;
    private final c_WrongInput wrongInput = new c_WrongInput();
    public Handler(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void handle(BotRequest request, AnswerWriter writer) {
        boolean messageSent = false;
        for (Command command : commands) {
            if (command.needExecute(request)) {
                messageSent = true;
                command.execute(request, writer);
            }
        }
        if(!messageSent) wrongInput.execute(request, writer);

    }
}