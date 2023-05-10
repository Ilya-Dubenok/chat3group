package by.academy.threegroup.dao.factory;

import by.academy.threegroup.dao.MessageMemoryDao;

public class MessageMemoryDaoFactory {
    private static volatile MessageMemoryDao instance;

    public static MessageMemoryDao getInstance() {
        if (instance == null) {
            synchronized (MessageMemoryDaoFactory.class){
                if (instance == null){
                    instance = new MessageMemoryDao();
                }
            }
        }
        return instance;
    }
}
