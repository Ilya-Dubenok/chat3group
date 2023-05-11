package by.academy.threegroup.dao.factory;

import by.academy.threegroup.dao.api.IUserDao;
import by.academy.threegroup.dao.memory.UserDao;

public class UserDaoFactory {

    private static IUserDao instance;

    private UserDaoFactory() {
    }

    public static IUserDao getInstance(){
        if(instance == null){
            synchronized (UserDaoFactory.class){
                if(instance == null){
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }
}
