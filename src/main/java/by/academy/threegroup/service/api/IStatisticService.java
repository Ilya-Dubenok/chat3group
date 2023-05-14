package by.academy.threegroup.service.api;

public interface IStatisticService {

    int incrementCountOfUsers();

    int decrementCountOfUsers();

    int incrementCountOfMessages();

    int getCountOfActiveUsers();

    int getCountOfRegisteredUsers();

    int getCountOfMessages();


}
