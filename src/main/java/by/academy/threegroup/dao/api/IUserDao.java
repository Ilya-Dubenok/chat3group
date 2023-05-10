package by.academy.threegroup.dao.api;

import by.academy.threegroup.core.UserDTO;

public interface IUserDao {
    UserDTO get(String login);
}
