package by.academy.threegroup.service.api;


import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;

public interface IUserService extends ICRUDService<UserDTO, UserCreateDTO>{
    UserDTO get(String login);
}
