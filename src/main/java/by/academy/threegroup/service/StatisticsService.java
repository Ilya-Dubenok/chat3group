package by.academy.threegroup.service;

import by.academy.threegroup.dao.api.IStatisticDao;
import by.academy.threegroup.service.api.IStatisticService;
import by.academy.threegroup.service.factory.UserServiceFactory;

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
    public int getCountOfActiveUsers() {
        return statisticDao.getCountOfUsers();
    }

    @Override
    public int getCountOfRegisteredUsers() {

        return UserServiceFactory.getInstance().get().size();
    }

    @Override
    public int getCountOfMessages() {
        return statisticDao.getCountOfMessages();
    }
}
