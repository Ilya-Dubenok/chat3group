package by.academy.threegroup.service.factory;

import by.academy.threegroup.dao.memory.factory.UserDaoFactory;
import by.academy.threegroup.service.UserService;
import by.academy.threegroup.service.api.IUserService;

public class UserServiceFactory {

    private static IUserService instance;

    private UserServiceFactory() {
    }

    public static IUserService getInstance(){
        if(instance == null){
            synchronized (UserServiceFactory.class){
                if(instance == null){
                    instance = new UserService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
