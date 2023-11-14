package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.MessageHandler;

import java.util.List;

/**
 * Класс, обрабатывающий запрос пользователя
 */
public class Handler implements MessageHandler {
    private final List<Command> commands;

    public Handler(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void handle(BotRequest request, AnswerWriter writer) {
        for (Command command : commands) {
            if (command.needExecute(request)) {
                command.execute(request, writer);
            }
        }
    }
}