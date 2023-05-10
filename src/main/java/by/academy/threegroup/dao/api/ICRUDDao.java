package by.academy.threegroup.dao.api;

import java.util.List;

public interface ICRUDDao<T> {

    List<T> get();

    T save(T item);
}
