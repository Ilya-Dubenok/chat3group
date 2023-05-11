package by.academy.threegroup.service;

import by.academy.threegroup.core.UserCreateDTO;

import java.util.regex.Pattern;

public class UserValidationService {

    private static final String LOGIN_PATTERN = "[a-zA-Z0-9][\\w.]+[a-zA-Z0-9]";
    private static final String DAY_PATTERN = "[0-2][1-9]|31|30|10|20";
    private static final String MONTH_PATTERN = "0[1-9]|1[0-2]";
    private static final String YEAR_PATTERN = "[1-2]\\d{3}";
    private static final String DAY_MONTH_PATTERN = "2902|3002|3102|3104|3106|3109|3111";
    private static final String DAY_MONTH_LEAP_PATTERN = "3002|3102|3104|3106|3109|3111";


    public static void validate(UserCreateDTO dto) {
        validateLogin(dto.getLogin());
        validatePassword(dto.getPassword());
        validateDateOfBirth(dto.getDateOfBirth());
    }

    //    TODO
    private static void validatePassword(String password) {
        if(password.length() < 7){
            throw new IllegalArgumentException("Password is too short. Must be not less than 7 symbols");
        }
    }

//    TODO
    private static void validateLogin(String login){
        if(!Pattern.matches(LOGIN_PATTERN, login)){
            throw new IllegalArgumentException("Login must contains latin letters, digits, \"_\",\".\". It can't begin and end with \"-\", \".\"");
        }
    }


    private static void validateDateOfBirth(String dateOfBirth) {

        if (dateOfBirth.length() != 10) {
            throw new IllegalArgumentException("Invalid length of date of birth");
        }

        String[] dateParts = dateOfBirth.split("-");

        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Invalid format of date of birth");
        }

        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        if (!Pattern.matches(DAY_PATTERN, day)) {
            throw new IllegalArgumentException("Incorrect day of month");
        }

        if (!Pattern.matches(MONTH_PATTERN, month)) {
            throw new IllegalArgumentException("Incorrect month");
        }

        if (!Pattern.matches(YEAR_PATTERN, year)) {
            throw new IllegalArgumentException("Incorrect year");
        }

        if (!validateDayMonth(day, month, year)) {
            throw new IllegalArgumentException("Incorrect year");
        }
    }

    private static boolean validateDayMonth(String day, String month, String year) {
        String dayMonth = day + month;
        if (isLeapYear(year)) {
            return !Pattern.matches(DAY_MONTH_LEAP_PATTERN, dayMonth);
        } else {
            return !Pattern.matches(DAY_MONTH_PATTERN, dayMonth);
        }
    }

    private static boolean isLeapYear(String year) {
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
