package by.academy.threegroup.dao.factory;

import by.academy.threegroup.dao.StatisticsMemoryDao;

public class StatisticsMemoryDaoFactory {

    private static class Holder{
        private final static StatisticsMemoryDao instance = new StatisticsMemoryDao();

    }
    private StatisticsMemoryDaoFactory() {

    }
    public static StatisticsMemoryDao getInstance() {
        return Holder.instance;
    }

}
