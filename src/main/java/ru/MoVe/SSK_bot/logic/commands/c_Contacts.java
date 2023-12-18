package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Contacts implements Command {
    private final static String id = "/contacts";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                Общежитие УрФУ №6: ул. Чапаева 16а
                
                <u>Администрация СК№6</u>:
                Маркова Галина Николаевна- Заведующая СК №6
                    тел: +7-(343)-257-01-61
                Крутикова Эльвира Асхатовна - Заведующая хозяйством
                
                Дежурный слесарь: +7-(982)-639-08-12
                Дежурный электрик: +7-(908)-916-86-40
                
                Паспортный стол: ул. Чапаева 16
                
                Группа общежития ВКонтакте:
                https://vk.com/hostel_urfu_6
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
