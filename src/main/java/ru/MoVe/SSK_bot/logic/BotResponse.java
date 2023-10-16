package ru.MoVe.SSK_bot.logic;

public class BotResponse {
    /**
     * response to user's request
     */
    private String responseText;
    private final String responseID;

    public BotResponse(String data, String id) {
        this.responseText = data;
        this.responseID = id;
    }

    public String getResponseText() {
        return responseText;
    }

    public String getResponseID() {
        return responseID;
    }

    public void setResponseText(String data) {
        this.responseText = data;
    }

    public void CreateAnswer() {
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if(responseText.equals("/start"))
            response = "Здравствуй, студент! Бот Совета Студенческих Корпусов (ССК) поможет тебе узнать основную информацию об общежитии.";
        else if(responseText.equals("/info"))
            response = "Пока функционала нет, но вы держитесь.";
        else
            response = responseText;

        responseText = response;
    }

}
