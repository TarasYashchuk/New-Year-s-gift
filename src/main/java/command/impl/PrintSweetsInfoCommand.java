package command.impl;

import command.Command;
import dao.GiftDao;
import model.Sweets;
import model.SweetsList;

import java.util.List;

public class PrintSweetsInfoCommand implements Command {
    private final GiftDao giftDao;

    public PrintSweetsInfoCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
        List<Sweets> sweetsList = SweetsList.getSweetsList();
        if (sweetsList.isEmpty()) {
            System.out.println("Список цукерок порожній.");
        } else {
            for (Sweets sweets : sweetsList) {
                System.out.println(sweets.toString());
            }
        }
    }

    @Override
    public String getDescription() {
        return "Інформація про всі солодощі";
    }
}
