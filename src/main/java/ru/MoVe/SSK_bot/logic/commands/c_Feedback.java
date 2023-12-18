package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Feedback implements Command {
    private final static String id = "/feedback";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                Если у вас есть, что нам сказать,
                то вы можете поделиться этим в своём следующем сообщении
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
