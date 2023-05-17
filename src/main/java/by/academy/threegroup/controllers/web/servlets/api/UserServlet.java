package by.academy.threegroup.controllers.web.servlets.api;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.service.api.IUserLogUpService;
import by.academy.threegroup.service.api.IUserService;
import by.academy.threegroup.service.factory.UserLogUpServiceFactory;
import by.academy.threegroup.service.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.net.URLEncoder;


@WebServlet(urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String CHECK_PASSWORD_PARAM = "checkPassword";
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String SURNAME_PARAM = "surname";
    private static final String DATE_OF_BIRTH_PARAM = "dateOfBirth";
    private static final String EXCEPTION_MESSAGE_PARAM = "exceptionMessage";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        IUserService userService = UserServiceFactory.getInstance();
        List<UserDTO> userDTOS = userService.get();
        StringBuilder message = new StringBuilder();
        userDTOS.forEach(u -> {
            message.append(u.toString());
            message.append("<br>");
        });

        writer.write(message.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();

        String login = getValue(parameterMap, LOGIN_PARAM);
        String password = getValue(parameterMap, PASSWORD_PARAM);
        String checkPassword = getValue(parameterMap, CHECK_PASSWORD_PARAM);
        String firstName = getValue(parameterMap, FIRST_NAME_PARAM);
        String lastName = getValue(parameterMap, LAST_NAME_PARAM);
        String surname = getValue(parameterMap, SURNAME_PARAM);
        String dateOfBirth = getValue(parameterMap, DATE_OF_BIRTH_PARAM);

        boolean isValid = !(login == null || password == null || firstName == null || lastName == null || dateOfBirth == null);

        if (!isValid) {
            resp.sendError(400);
        }

        UserCreateDTO dto = new UserCreateDTO();
        dto.setLogin(login);
        dto.setPassword(password);
        dto.setCheckPassword(checkPassword);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setSurname(surname);
        dto.setDateOfBirth(dateOfBirth);

        IUserLogUpService userLogUpService = UserLogUpServiceFactory.getInstance();
        String message = null;
        try {
            userLogUpService.save(dto);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }

        String[] referer = req.getHeader("referer").split("\\?");
        String path = req.getContextPath();

        if (message == null) {
            resp.sendRedirect(path + "/ui/");
        } else {
            String encodeMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
            String link = referer[0] + "?" + EXCEPTION_MESSAGE_PARAM + "=" + encodeMessage;
            resp.sendRedirect(link);
        }
    }

    private String getValue(Map<String, String[]> map, String paramName) {
        String value = null;
        if (map.containsKey(paramName)) {
            String[] logins = map.get(paramName);
            if (logins != null && logins.length == 1) {
                if (!"".equals(logins[0])) {
                    value = logins[0];
                }
            }
        }
        return value;
    }


}
