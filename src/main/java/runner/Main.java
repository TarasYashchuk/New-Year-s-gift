package runner;
import org.apache.log4j.Logger;
import command.Command;
import command.impl.AddCandyToGiftCommand;
import command.impl.CalculateGiftWeightCommand;
import command.impl.FindCandyBySugarContentCommand;
import command.impl.GetGiftCompositionCommand;
import command.impl.PrintSweetsInfoCommand;
import command.impl.RemoveCandyFromGiftCommand;
import command.impl.SortCandiesCommand;
import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import lib.Injector;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String PATH = "org.example";
    private static final Injector injector = Injector.getInstance(PATH);
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        GiftDao giftDao = new GiftDaoImpl();
        Map<String, Command> commandMap = new HashMap<>();

        commandMap.put("add", new AddCandyToGiftCommand(giftDao));
        commandMap.put("weight", new CalculateGiftWeightCommand(giftDao));
        commandMap.put("contain", new GetGiftCompositionCommand(giftDao));
        commandMap.put("find", new FindCandyBySugarContentCommand(giftDao));
        commandMap.put("info", new PrintSweetsInfoCommand(giftDao));
        commandMap.put("remove", new RemoveCandyFromGiftCommand(giftDao));
        commandMap.put("sort", new SortCandiesCommand(giftDao));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть команду (або 'help' для виведення списку команд): ");
            String choice = scanner.nextLine();

            logger.info("Користувач ввів команду: " + choice);

            try{
                if (choice.equals("help")) {
                    System.out.println("Доступні команди:");
                    for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
                        System.out.println(entry.getKey() + " >> " + entry.getValue().getDescription());
                    }
                } else if (choice.equals("exit")) {
                    System.out.println("Дякую за використання програми!");
                    logger.info("Програма завершила роботу.");
                    System.exit(0);
                } else if (commandMap.containsKey(choice)) {
                    String commandDescription = commandMap.get(choice).getDescription();
                    System.out.println("Ви обрали команду: " + commandDescription);
                    logger.info("Виконується обробка команди " + commandDescription);
                    commandMap.get(choice).execute();
                } else {
                    throw new IllegalArgumentException("Неправильна команда. Введіть 'help' для виведення списку команд.");
                }
            } catch (Exception e){
                logger.info("Помилка: " + e.getMessage());
                e.printStackTrace();

            }
        }
    }
}
