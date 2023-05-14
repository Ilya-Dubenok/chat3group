package by.academy.threegroup.controllers.web.listeners;

import by.academy.threegroup.service.api.IStatisticService;
import by.academy.threegroup.service.factory.StatisticsServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ActiveUsersNumberListener implements HttpSessionAttributeListener {

    IStatisticService statisticService = StatisticsServiceFactory.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        if ("user".equals(event.getName())) {
            statisticService.incrementCountOfUsers();
        }


    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if("user".equals(event.getName())){
            statisticService.decrementCountOfUsers();
        };

    }
}
