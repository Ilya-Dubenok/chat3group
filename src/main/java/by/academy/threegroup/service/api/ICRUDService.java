package by.academy.threegroup.service.api;

import java.util.List;

public interface ICRUDService <T, K>{

    List<T> get();

    T save(K item);
}
