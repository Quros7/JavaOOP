package ru.MoVe.SSK_bot.logic;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.MessageHandler;

public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        String responseText = CreateAnswer(request);
        BotResponse response = new BotResponse(responseText, request.getRequestID());
        writer.writeAnswer(response);
    }

    public String CreateAnswer(BotRequest request) {
        String requestText = request.getRequestText();
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ

        if(requestText.equals("/start"))
            response = "Здравствуй, студент!\n" +
                    "Бот Совета Студенческих Корпусов (ССК) поможет тебе узнать основную информацию об общежитии.\n" +
                    "Помощь по функционалу —> /help";
        else if(requestText.equals("/help"))
            response = "Бот подскажет тебе доступную информацию про СК №6.\n"+
                    "Доступные команды:\n" +
                    "/start - начальный экран\n" +
                    "/info - общая информация об общежитии\n" +
                    "/contacts - все важные контакты общежития\n" +
                    "/events - предстоящие мероприятия\n" +
                    "/feedback - оставить отзыв";
        else if(requestText.equals("/info"))
            response = "<u>Общая характеристика общежития №6:</u>\n" +
                    "Студенческое общежитие №6 находится по " +
                    "<b><i>адресу ул. Чапаева, д. 16а</i></b>" +
                    ", где располагаются студенты, аспиранты, семейные студенты, сотрудники. Общежитие было построено в 1987 году. " +
                    "Здание - блочного типа, имеет 9 этажей, 318 жилых комнат. На каждом этаже есть кухня. " +
                    "На данный момент здесь проживает 450 студентов. " +
                    "В общежитии функционирует теннисный зал и учебная комната.";
            // TODO: 07.11.2023 добавить кнопки теннисного зала и учебной комнаты, инфу про интернет, про время работы общаги, про гостей
        else if(requestText.equals("/contacts"))
            response = "Тут будут контакты...";
        else if(requestText.equals("/events"))
            response = "Тут будут мероприятия...";
        else if(requestText.equals("/feedback"))
            response = "Тут будут отзывы...";
        else
            response = "Неверный ввод";

        return response;
    }
}
