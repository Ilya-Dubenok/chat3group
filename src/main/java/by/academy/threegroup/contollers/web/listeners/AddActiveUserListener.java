package by.academy.threegroup.contollers.web.listeners;

import by.academy.threegroup.service.api.IStatisticService;
import by.academy.threegroup.service.factory.StatisticsServiceFactory;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class AddActiveUserListener implements HttpSessionAttributeListener {

    IStatisticService statisticService = StatisticsServiceFactory.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        if ("user".equals(event.getName())) {
            statisticService.incrementCountOfUsers();
        }


    }
}
