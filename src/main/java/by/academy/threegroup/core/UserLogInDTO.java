package by.academy.threegroup.core;

public class UserLogInDTO {
    private String login;
    private String password;

    public UserLogInDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
