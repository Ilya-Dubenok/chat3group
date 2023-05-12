package by.academy.threegroup.service.factory;

import by.academy.threegroup.service.UserLogUpService;
import by.academy.threegroup.service.api.IUserLogUpService;

public class UserLogUpServiceFactory {

    private static IUserLogUpService instance;

    private UserLogUpServiceFactory() {
    }

    public static IUserLogUpService getInstance(){
        if(instance == null){
            synchronized (UserLogUpServiceFactory.class){
                if(instance == null){
                    instance = new UserLogUpService(UserServiceFactory.getInstance(), UserValidationServiceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
