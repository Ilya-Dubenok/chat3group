package by.academy.threegroup.core;
import by.academy.threegroup.core.enums.UserRoles;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate registrationDate;
    private UserRoles role;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String firstName, String lastName, String surname, LocalDate dateOfBirth, LocalDate registrationDate, UserRoles role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.role = role;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;

        return Objects.equals(login, userDTO.login) && Objects.equals(password, userDTO.password) && Objects.equals(firstName, userDTO.firstName) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(surname, userDTO.surname) && Objects.equals(registrationDate, userDTO.registrationDate) && role == userDTO.role;
    }

    @Override
    public int hashCode() {

        return Objects.hash(login, password, firstName, lastName, surname, registrationDate, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }
}
