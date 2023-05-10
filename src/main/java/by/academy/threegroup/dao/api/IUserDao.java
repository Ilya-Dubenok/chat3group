package by.academy.threegroup.dao.api;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;

public interface IUserDao extends ICRUDDao<UserDTO>{
    UserDTO get(String login);
}
