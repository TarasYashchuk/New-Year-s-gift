package command.impl;

import command.Command;
import dao.GiftDao;
import model.Sweets;

import java.util.List;

public class SortGiftByWeightCommand implements Command {
    private final GiftDao giftDao;

    public SortGiftByWeightCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
        List<Sweets> sortedGift = giftDao.sortGiftByWeight();
        sortedGift.forEach(sweet -> System.out.println(sweet.getName() + " - Weight: " + sweet.getWeight() + " grams"));
    }

    @Override
    public String getDescription() {
        return null;
    }
}
