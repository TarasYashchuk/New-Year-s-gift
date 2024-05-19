package command.impl;

import command.Command;
import dao.GiftDao;

import java.util.InputMismatchException;
import java.util.Scanner;

import static runner.Main.logger;

public class SortCandiesCommand implements Command {
    private final GiftDao giftDao;

    public SortCandiesCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
        logger.info("Команда 'sortCandies' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть тип сортування:");
        System.out.println("1. за назвою цукерки");
        System.out.println("2. за вмістом цукру");
        System.out.println("3. за вагою");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> new SortGiftByNameCommand(giftDao).execute();
                case 2 -> new SortGiftBySugarContentCommand(giftDao).execute();
                case 3 -> new SortGiftByWeightCommand(giftDao).execute();
                default -> System.out.println("Такого пункту немає");
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильний ввід. Введіть числове значення.");
            logger.warn("Неправильний ввід при сортуванні цукерок: " + e.getMessage());
        }
        logger.info("Команда 'SortCandies' закінчила роботу.");
    }

    @Override
    public String getDescription() {
        return "Відсортувати цукерки";
    }
}
