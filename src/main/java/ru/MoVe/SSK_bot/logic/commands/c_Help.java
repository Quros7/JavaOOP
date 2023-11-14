package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Help implements Command {
    private final static String id = "/help";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                        Бот подскажет тебе доступную информацию про СК №6.
                        Доступные команды:
                        /start - начальный экран
                        /info - общая информация об общежитии
                        /contacts - все важные контакты общежития
                        /events - предстоящие мероприятия
                        /feedback - оставить отзыв""";
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
