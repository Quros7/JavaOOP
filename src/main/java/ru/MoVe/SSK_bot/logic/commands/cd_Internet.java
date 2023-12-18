package ru.MoVe.SSK_bot.logic.commands;

import ru.MoVe.SSK_bot.AnswerWriter;
import ru.MoVe.SSK_bot.Command;
import ru.MoVe.SSK_bot.logic.BotRequest;
import ru.MoVe.SSK_bot.logic.BotResponse;

import java.util.Objects;

public class cd_Internet implements Command {
    private final static String id = "internet";

    @Override
    public boolean needExecute(BotRequest request) {
        return Objects.equals(request.getRequestText(), id);
    }

    @Override
    public void execute(BotRequest request, AnswerWriter writer) {
        String responseText = """
                В общежитиях УрФУ используются следующие способы доступа к Интернет:
                
                • Беспроводной доступ через Wi-Fi.
                    Предоставляется бесплатно, аналогично учебным корпусам (подробнее).
                
                • Кабельный доступ к Интернет от УрФУ (для учебных целей).
                    Лимитированный доступ предоставляется бесплатно в 1-16 с/к, аналогично учебным корпусам (подробнее)
                • Кабельный доступ к Интернет от Convex (скоростной).
                    Платный доступ в 1-16 с/к.
                    Для подключения необходимо оставить заявку или позвонить по телефону +7 (343) 386-08-08
                • Кабельный доступ к Интернет от УГМК-Телеком (скоростной).
                    Платный доступ в 1-16 с/к.
                    Для подключения необходимо оставить заявку или позвонить по телефону +7 (800) 7000-400
                • Кабельный доступ к Интернет от Эрланг-Коммуникации (скоростной).
                    Платный доступ в 1-16 с/к.
                    Для подключения необходимо оставить заявку или позвонить по телефону +7 (343) 263-79-63
                • Кабельный доступ к Интернет от Дом.ру (скоростной).
                    Платный доступ в 3, 5, 6, 7, 8, 10, 13-16 с/к.
                    Для подключения необходимо позвонить по телефону +7 (800) 333-7000
                
                Обращаем ваше внимание на то, что на любом компьютере, подключенному к кабельной сети,
                внутренние ресурсы УрФУ (включая все образовательные платформы) доступны на скорости от 100 до 1000 Мбит/с.
                
                Подробнее здесь:
                https://dit.urfu.ru/ru/servisy/dorm/
                """;
        writer.writeAnswer(new BotResponse(responseText, request.getRequestID()));
    }
}
