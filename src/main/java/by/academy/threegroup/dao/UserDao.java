package by.academy.threegroup.dao;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.dao.api.IUserDao;

import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {
    private Map<String, UserDTO> users;

    public UserDao() {
        users = new HashMap<>();
        UserDTO admin = new UserDTO("Admin", "admin123");
        users.put(admin.getLogin(), admin);
    }

    @Override
    public UserDTO get(String login) {
        UserDTO user = users.get(login);
        return user;
    }
}
