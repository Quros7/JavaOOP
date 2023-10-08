package ru.MoVe.SSK_bot.console;

import ru.MoVe.SSK_bot.InputReader;
import ru.MoVe.SSK_bot.logic.BotRequest;

import java.util.Scanner;

public class Reader implements InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public BotRequest getUserInput() {
        return (new BotRequest(scanner.nextLine()));
    }
}
