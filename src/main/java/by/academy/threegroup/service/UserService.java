package by.academy.threegroup.service;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.dao.api.IUserDao;
import by.academy.threegroup.service.api.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDTO> get() {
        return userDao.get();
    }

    @Override
    public UserDTO get(String login) {
        UserDTO userDTO = userDao.get(login);
        if (userDTO == null) {
            throw new IllegalArgumentException("Such user doesn't exist");
        }
        return userDTO;
    }

    @Override
    public UserDTO save(UserDTO user) {

        return userDao.save(user);
    }

}
