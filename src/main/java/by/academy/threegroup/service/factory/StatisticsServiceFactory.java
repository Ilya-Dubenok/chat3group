package by.academy.threegroup.service.factory;

import by.academy.threegroup.dao.memory.factory.StatisticsMemoryDaoFactory;
import by.academy.threegroup.service.StatisticsService;


public class StatisticsServiceFactory {

    private static class Holder{
        private static final StatisticsService instance = new StatisticsService(StatisticsMemoryDaoFactory.getInstance());

    }

    private StatisticsServiceFactory() {

    }


    public static StatisticsService getInstance() {
        return Holder.instance;
    }

}
