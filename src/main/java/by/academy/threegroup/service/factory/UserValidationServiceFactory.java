package by.academy.threegroup.service.factory;

import by.academy.threegroup.service.UserValidationService;
import by.academy.threegroup.service.api.IUserValidationService;

public class UserValidationServiceFactory {

    private static IUserValidationService instance;

    private UserValidationServiceFactory() {
    }

    public static IUserValidationService getInstance(){
        if(instance == null){
            synchronized (UserValidationServiceFactory.class){
                if(instance == null){
                    instance = new UserValidationService(UserServiceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
