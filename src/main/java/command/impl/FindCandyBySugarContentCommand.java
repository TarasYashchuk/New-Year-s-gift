package command.impl;

import command.Command;
import dao.GiftDao;

public class FindCandyBySugarContentCommand implements Command {
    private final GiftDao giftDao;

    public FindCandyBySugarContentCommand(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    @Override
    public void execute() {
            giftDao.getBySugarContent();
    }

    @Override
    public String getDescription() {
        return "Знайти цукерку за певним вмістом цукру";
    }
}
