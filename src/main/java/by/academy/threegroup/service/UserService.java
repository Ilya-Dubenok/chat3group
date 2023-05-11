package by.academy.threegroup.service;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import by.academy.threegroup.dao.api.IUserDao;
import by.academy.threegroup.service.api.IUserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserService implements IUserService {

    private static final String DATE_OF_BIRTH_FORMAT = "dd-MM-yyyy";

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
    public UserDTO save(UserCreateDTO item) {

        UserValidationService.validate(item);

        String login = item.getLogin();
        Integer password = item.getPassword().hashCode();
        String firstName = item.getFirstName();
        String lastName = item.getLastName();
        String surname = item.getSurname();
        LocalDate dateOfBirth = parseDateOfBirth(item.getDateOfBirth());
        LocalDate registrationDate = LocalDate.now();

        UserDTO dto = new UserDTO(login, password, firstName, lastName, surname, dateOfBirth, registrationDate, UserRoles.USER);

        return userDao.save(dto);
    }


    private LocalDate parseDateOfBirth(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_OF_BIRTH_FORMAT);
        LocalDate dateOfBirth = LocalDate.parse(date, formatter);

        return dateOfBirth;
    }
}
