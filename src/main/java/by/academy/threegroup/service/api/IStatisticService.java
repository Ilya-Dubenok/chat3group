package by.academy.threegroup.service.api;

public interface IStatisticService {

    int incrementCountOfUsers();

    int decrementCountOfUsers();

    int incrementCountOfMessages();

    int getCountOfUsers();

    int getCountOfMessages();


}
