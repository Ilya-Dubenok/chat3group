package by.academy.threegroup.core;

import java.time.LocalDate;

public class UserCreateDTO {
    private String login;
    private String password;
    private String checkPassword;
    private String firstName;
    private String lastName;
    private String surname;
    private String dateOfBirth;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String login, String password, String checkPassword, String firstName, String lastName, String surname, String dateOfBirth) {
        this.login = login;
        this.password = password;
        this.checkPassword = checkPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
