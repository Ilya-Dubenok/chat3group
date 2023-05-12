package by.academy.threegroup.service;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.UserLogInDTO;
import by.academy.threegroup.dao.api.IUserDao;
import jakarta.servlet.http.HttpSession;

public class UserLogInService {
    private final HttpSession session;
    private final IUserDao userDao;

    public UserLogInService(HttpSession session, IUserDao userDao) {
        this.session = session;
        this.userDao = userDao;
    }

    public void logIn(UserLogInDTO dto) {
        UserDTO user = userDao.get(dto.getLogin());
        if(user != null) {
            if(user.getPassword().equals(dto.getPassword())) {
                this.session.setAttribute("user", user);
            } else {
                throw new IllegalArgumentException("Wrong password.");
            }
        } else {
            throw new IllegalArgumentException("Wrong login.");
        }
    }
}
