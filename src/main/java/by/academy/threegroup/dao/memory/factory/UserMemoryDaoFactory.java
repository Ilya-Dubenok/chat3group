package by.academy.threegroup.dao.memory.factory;

import by.academy.threegroup.dao.api.IUserDao;
import by.academy.threegroup.dao.memory.UserMemoryDao;

public class UserMemoryDaoFactory {

    private static IUserDao instance;

    private UserMemoryDaoFactory() {
    }

    public static IUserDao getInstance(){
        if(instance == null){
            synchronized (UserMemoryDaoFactory.class){
                if(instance == null){
                    instance = new UserMemoryDao();
                }
            }
        }
        return instance;
    }
}
