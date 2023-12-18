package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class c_Info implements Command {
    private final static String id = "/info";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                        <u>Общая характеристика общежития №6:</u>
                        Студенческое общежитие №6 находится по
                        <b><i>адресу ул. Чапаева, д. 16а</i></b>,
                        где располагаются студенты, аспиранты, семейные студенты, сотрудники.
                        Общежитие было построено в 1987 году.
                        Здание - блочного типа, имеет 9 этажей, 318 жилых комнат.
                        В каждом блоке есть кухня на несколько комнат.
                        В каждой секции внутри блока есть туалет и душ на 2 комнаты.
                        На данный момент здесь проживает около 450 студентов.
                        В общежитии функционирует теннисный зал и учебная комната.
                        """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID(), true));
        //BotResponse(responseText, responseId, hasKeyboard);
    }
}
