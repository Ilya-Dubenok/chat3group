package by.academy.threegroup.core;

import java.util.Objects;

public class UserDTO implements IDTO{
    private final String login;

    public UserDTO(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(login, userDTO.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
