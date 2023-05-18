package by.academy.threegroup.service;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import by.academy.threegroup.service.api.IUserLogUpService;
import by.academy.threegroup.service.api.IUserService;
import by.academy.threegroup.service.api.IUserValidationService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserLogUpService implements IUserLogUpService {

    private static final String DATE_OF_BIRTH_FORMAT = "yyyy-MM-dd";
    private IUserService userService;
    private IUserValidationService userValidationService;

    public UserLogUpService(IUserService userService, IUserValidationService userValidationService) {
        this.userService = userService;
        this.userValidationService = userValidationService;
    }


    @Override
    public void save(UserCreateDTO user) {
        this.userValidationService.validate(user);

        String login = user.getLogin();
        Integer password = user.getPassword().hashCode();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String surname = user.getSurname();
        LocalDate dateOfBirth = parseDateOfBirth(user.getDateOfBirth());
        LocalDate registrationDate = LocalDate.now();

        UserDTO dto = new UserDTO(login, password, firstName, lastName, surname, dateOfBirth, registrationDate, UserRoles.USER);
        this.userService.save(dto);
    }

    private LocalDate parseDateOfBirth(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_OF_BIRTH_FORMAT);
        LocalDate dateOfBirth = LocalDate.parse(date, formatter);

        return dateOfBirth;
    }
}