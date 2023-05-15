package by.academy.threegroup.dao.memory.factory;

import by.academy.threegroup.dao.memory.MessageMemoryDao;

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
