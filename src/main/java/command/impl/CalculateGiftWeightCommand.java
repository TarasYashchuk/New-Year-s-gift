package command.impl;

import command.Command;
import dao.GiftDao;

public class CalculateGiftWeightCommand implements Command {
    private final GiftDao giftDao;

    public CalculateGiftWeightCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
        giftDao.calculateGiftWeight();
    }

    @Override
    public String getDescription() {
        return "Вага всього подарунка";
    }
}
