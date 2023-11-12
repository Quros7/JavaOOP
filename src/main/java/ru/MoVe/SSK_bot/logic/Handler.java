package ru.MoVe.SSK_bot.logic;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.MessageHandler;

import java.util.List;

/**
 * Класс, обрабатывающий запрос пользователя
 */
public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        final String requestId = request.getRequestID();
        String responseText;
        BotResponse response;

        responseText = CreateTextAnswer(request);
        response = new BotResponse(responseText, requestId);
        /*
          Проверяем, что запрос был вызван не нажатием кнопки и сравниваем с командой /info
          Отдельная проверка нужна, потому что в ответном сообщении есть клавиатура
          и для неё нужен отдельный конструктор BotRequest-а
         */
        if((!request.isButtonPressed())&&(request.getRequestText().equals("/info"))){
            InlineKeyboardMarkup keyboard = createKeyboard();
            response = new BotResponse(responseText, requestId, keyboard);
        }
        writer.writeAnswer(response);
    }

    /**
     * Функция, создающая текстовую часть ответа пользователю
     * @param request BotRequest
     * @return текстовая часть ответа
     */
    public String CreateTextAnswer(BotRequest request){
        String requestText = request.getRequestText();
        String callData = request.getCallData();
        String responseText="";

        if(!request.isButtonPressed()) {
            responseText = switch (requestText) {
                case "/start" -> "Здравствуй, студент!\n" +
                        "Бот Совета Студенческих Корпусов (ССК) поможет тебе узнать основную информацию об общежитии.\n" +
                        "Помощь по функционалу —> /help";

                case "/help" -> "Бот подскажет тебе доступную информацию про СК №6.\n" +
                        "Доступные команды:\n" +
                        "/start - начальный экран\n" +
                        "/info - общая информация об общежитии\n" +
                        "/contacts - все важные контакты общежития\n" +
                        "/events - предстоящие мероприятия\n" +
                        "/feedback - оставить отзыв";

                case "/info" -> "<u>Общая характеристика общежития №6:</u>\n" +
                        "Студенческое общежитие №6 находится по " +
                        "<b><i>адресу ул. Чапаева, д. 16а</i></b>" +
                        ", где располагаются студенты, аспиранты, семейные студенты, сотрудники. Общежитие было построено в 1987 году. " +
                        "Здание - блочного типа, имеет 9 этажей, 318 жилых комнат. На каждом этаже есть кухня. " +
                        "На данный момент здесь проживает 450 студентов. " +
                        "В общежитии функционирует теннисный зал и учебная комната.";

                case "/contacts" -> "Тут будут контакты...";
                case "/events" -> "Тут будут мероприятия...";
                case "/feedback" -> "Тут будут отзывы...";
                default -> "Неверный ввод";
            };
        }
        else if(!callData.isEmpty()){
            switch (callData) {
                case "guests" -> responseText = "Инфа про гостей";
                case "internet" -> responseText = "Инфа об интернете";
                case "tennis" -> responseText = "Инфа о теннисном зале";
                case "studyRoom" -> responseText = "Инфа об учебной комнате";
            }
        }
        else responseText = "Вы сломали бота...";
        return responseText;
    }

    /**
     * Функцция, создающая клавиатура для ответа на команду /info
     * @return InlineKeyboardMarkup
     */
    InlineKeyboardMarkup createKeyboard(){
        var guests = InlineKeyboardButton.builder()
                .text("Правила посещения общежития гостями").callbackData("guests")
                .build();
        var internet = InlineKeyboardButton.builder()
                .text("Об интернете").callbackData("internet")
                .build();
        var tennis = InlineKeyboardButton.builder()
                .text("Теннисный зал").callbackData("tennis")
                .build();
        var studyRoom = InlineKeyboardButton.builder()
                .text("Учебный зал").callbackData("studyRoom")
                .build();

        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(guests))
                .keyboardRow(List.of(internet))
                .keyboardRow(List.of(tennis))
                .keyboardRow(List.of(studyRoom))
                .build();
    }
}
