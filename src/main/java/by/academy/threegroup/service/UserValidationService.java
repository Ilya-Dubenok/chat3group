package by.academy.threegroup.service;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.service.api.IUserService;
import by.academy.threegroup.service.api.IUserValidationService;

import java.util.regex.Pattern;

public class UserValidationService implements IUserValidationService {

    private static final String LOGIN_PATTERN = "[a-zA-Z0-9][\\w.]+[a-zA-Z0-9]";
    private static final String DAY_PATTERN = "[0-2][1-9]|31|30|10|20";
    private static final String MONTH_PATTERN = "0[1-9]|1[0-2]";
    private static final String YEAR_PATTERN = "[1-2]\\d{3}";
    private static final String DAY_MONTH_PATTERN = "2902|3002|3102|3104|3106|3109|3111";
    private static final String DAY_MONTH_LEAP_PATTERN = "3002|3102|3104|3106|3109|3111";

    private IUserService userService;

    public UserValidationService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(UserCreateDTO dto) {
        validateLogin(dto.getLogin());
        validatePassword(dto.getPassword(), dto.getCheckPassword());
        validateDateOfBirth(dto.getDateOfBirth());
    }

    private void validatePassword(String password, String checkPassword) {
        if (!password.equals(checkPassword)) {
            throw new IllegalArgumentException("Пароли не совпадают");
        }
        if (password.length() < 7) {
            throw new IllegalArgumentException("Пароль слишком короткий. Должен быть не менее 7 символов");
        }
    }

    private void validateLogin(String login) {

        if (!Pattern.matches(LOGIN_PATTERN, login)) {
            throw new IllegalArgumentException("Логин может содержать латинские буквы, цифры, \"_\",\".\". Логин не может начинаться с \"-\", \".\"");
        }

        UserDTO loginCheck = null;
        try{
            loginCheck = userService.get(login);
        }catch (IllegalArgumentException ignored){
        }

        if(loginCheck != null){
            throw new IllegalArgumentException("Такой логин уже существует");
        }

    }


    private void validateDateOfBirth(String dateOfBirth) {

        if (dateOfBirth.length() != 10) {
            throw new IllegalArgumentException("Неверная длина даты рождения");
        }

        String[] dateParts = dateOfBirth.split("-");

        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        String day = dateParts[2];
        String month = dateParts[1];
        String year = dateParts[0];

        if (!Pattern.matches(DAY_PATTERN, day)) {
            throw new IllegalArgumentException("Неверный день месяца");
        }

        if (!Pattern.matches(MONTH_PATTERN, month)) {
            throw new IllegalArgumentException("Неверныц месяц");
        }

        if (!Pattern.matches(YEAR_PATTERN, year)) {
            throw new IllegalArgumentException("Неверный год");
        }

        if (!validateDayMonth(day, month, year)) {
            throw new IllegalArgumentException("Неверная дата рождения");
        }
    }

    private boolean validateDayMonth(String day, String month, String year) {
        String dayMonth = day + month;
        if (isLeapYear(year)) {
            return !Pattern.matches(DAY_MONTH_LEAP_PATTERN, dayMonth);
        } else {
            return !Pattern.matches(DAY_MONTH_PATTERN, dayMonth);
        }
    }

    private boolean isLeapYear(String year) {
        int yearInt = Integer.parseInt(year);

        if (yearInt % 4 == 0) {
            if (yearInt % 100 == 0) {
                if (!(yearInt % 400 == 0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
