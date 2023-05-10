package by.academy.threegroup.service.factory;

import by.academy.threegroup.service.MessageService;

public class MessageServiceFactory {
    private static volatile MessageService instance;

    public static MessageService getInstance() {
        if (instance == null) {
            synchronized (MessageServiceFactory.class){
                if (instance == null){
                    instance = new MessageService();
                }
            }
        }
        return instance;
    }
}
