package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.MessageHandler;

public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        BotResponse response = new BotResponse(request.getRequestText(), request.getRequestID());
        response.setResponseText(this.CreateAnswer(request));
        writer.writeAnswer(response);
    }

    public String CreateAnswer(BotRequest request) {
        String textMessage = request.getRequestText();
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if(textMessage.equals("/start"))
            response = "Здравствуй, студент!\nБот Совета Студенческих Корпусов (ССК) поможет тебе узнать основную информацию об общежитии.\nПомощь по функционалу ---> /info";
        else if(textMessage.equals("/info"))
            response = "Пока функционала нет, но вы держитесь.";
        else
            response = textMessage;

        return response;
    }
}
