package by.academy.threegroup.service.factory;

import by.academy.threegroup.service.UserSignUpService;
import by.academy.threegroup.service.api.IUserSignUpService;

public class UserSignUpServiceFactory {

    private static IUserSignUpService instance;

    private UserSignUpServiceFactory() {
    }

    public static IUserSignUpService getInstance(){
        if(instance == null){
            synchronized (UserSignUpServiceFactory.class){
                if(instance == null){
                    instance = new UserSignUpService(UserServiceFactory.getInstance(), UserValidationServiceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
