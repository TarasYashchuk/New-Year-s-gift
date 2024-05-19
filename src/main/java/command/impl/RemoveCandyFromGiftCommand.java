package command.impl;

import command.Command;
import dao.GiftDao;

public class RemoveCandyFromGiftCommand implements Command {
    private final GiftDao giftDao;

    public RemoveCandyFromGiftCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
            giftDao.deleteSweetById();
        }

    @Override
    public String getDescription() {
        return "Вилучити цукерку з подарунка";
    }
}
