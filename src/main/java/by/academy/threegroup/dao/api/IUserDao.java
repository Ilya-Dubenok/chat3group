package by.academy.threegroup.dao.api;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;

import java.util.List;

public interface IUserDao{
    UserDTO get(String login);

    List<UserDTO> get();

    UserDTO save(UserDTO item);
}
