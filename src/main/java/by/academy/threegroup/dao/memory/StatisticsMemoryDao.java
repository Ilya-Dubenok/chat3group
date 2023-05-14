package by.academy.threegroup.dao.memory;

import by.academy.threegroup.dao.api.IStatisticDao;

public class StatisticsMemoryDao implements IStatisticDao {

    int countOfUsers = 0;

    int countOfMessages = 0;


    public StatisticsMemoryDao() {

    }


    @Override
    public synchronized int incrementCountOfUsers() {
        return ++countOfUsers;
    }

    @Override
    public synchronized int decrementCountOfUsers() {
        return --countOfUsers;
    }

    @Override
    public synchronized int incrementCountOfMessages() {
        return ++countOfMessages;
    }

    @Override
    public int getCountOfUsers() {
        return countOfUsers;
    }

    @Override
    public int getCountOfMessages() {
        return countOfMessages;
    }
}
