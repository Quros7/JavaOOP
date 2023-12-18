package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Events implements Command {
    private final static String id = "/events";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
        Несколько раз в месяц ССК (Совет Студенческих Корпусов)
        проводит мероприятия для студентов:
        
           • <i>Развлекательные (настольные игры, киновечера)</i>
           • <i>Образовательные (лекции, мастер-классы)</i>
           • <i>Спортивные (йога, турниры по теннису)</i>
        
        Актуальное расписание вы можете найти в группе
        общежития №6 ВКонтакте:
        https://vk.com/hostel_urfu_6
        """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
