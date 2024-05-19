package command.impl;

import command.Command;
import dao.GiftDao;
import model.Sweets;

import java.util.List;

public class SortGiftByNameCommand implements Command {
    private final GiftDao giftDao;

    public SortGiftByNameCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
        List<Sweets> sortedGift = giftDao.sortGiftByName();
        sortedGift.forEach(sweet -> System.out.println(sweet.getName()));
    }

    @Override
    public String getDescription() {
        return null;
    }
}

