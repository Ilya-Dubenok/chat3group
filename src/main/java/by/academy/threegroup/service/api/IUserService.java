package by.academy.threegroup.service.api;


import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO get(String login);

    List<UserDTO> get();

    UserDTO save(UserDTO user);
}
