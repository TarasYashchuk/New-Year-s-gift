package command.impl;

import command.Command;
import dao.GiftDao;

public class AddCandyToGiftCommand implements Command {
    private final GiftDao giftDao;

    public AddCandyToGiftCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
            giftDao.add();
        }

    @Override
    public String getDescription() {
        return "Додати цукерку до подарунка";
    }
}
