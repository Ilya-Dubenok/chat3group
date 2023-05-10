package by.academy.threegroup.dao.api;

public interface IStatisticDao {

    int incrementCountOfUsers();

    int decrementCountOfUsers();

    int incrementCountOfMessages();

    int getCountOfUsers();

    int getCountOfMessages();

}
