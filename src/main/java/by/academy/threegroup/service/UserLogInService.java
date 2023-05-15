package by.academy.threegroup.service;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.UserLogInDTO;
import by.academy.threegroup.service.api.IUserService;
import jakarta.servlet.http.HttpSession;

public class UserLogInService {
    private final HttpSession session;
    private final IUserService service;

    public UserLogInService(HttpSession session, IUserService service) {
        this.session = session;
        this.service = service;
    }

    public void logIn(UserLogInDTO dto) {
        UserDTO user = service.get(dto.getLogin());
        if(user != null) {
            if(user.getPassword().hashCode() == dto.getPassword().hashCode()) {
                this.session.setAttribute("user", user);
            } else {
                throw new IllegalArgumentException("Wrong password.");
            }
        } else {
            throw new IllegalArgumentException("Wrong login.");
        }
    }
}
