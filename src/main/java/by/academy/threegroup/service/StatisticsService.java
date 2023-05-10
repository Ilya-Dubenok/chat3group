package by.academy.threegroup.service;

import by.academy.threegroup.dao.api.IStatisticDao;
import by.academy.threegroup.service.api.IStatisticService;

public class StatisticsService implements IStatisticService {

    private final IStatisticDao statisticDao;

    public StatisticsService(IStatisticDao statisticDao) {
        this.statisticDao = statisticDao;

    }


    @Override
    public int incrementCountOfUsers() {
        return statisticDao.incrementCountOfUsers();
    }

    @Override
    public int decrementCountOfUsers() {
        return statisticDao.decrementCountOfUsers();
    }

    @Override
    public int incrementCountOfMessages() {
        return statisticDao.incrementCountOfMessages();
    }

    @Override
    public int getCountOfUsers() {
        return statisticDao.getCountOfUsers();
    }

    @Override
    public int getCountOfMessages() {
        return statisticDao.getCountOfMessages();
    }
}
