package ru.MoVe.SSK_bot.console;

import ru.MoVe.SSK_bot.InputReader;
import java.util.Scanner;

public class BotRequest implements InputReader {
    String textData;
    Scanner scanner = new Scanner(System.in);
    public BotRequest getUserInput() {
        textData = scanner.nextLine();
        return this;
    }
    public String getTextData() {
        return textData;
    }
}
