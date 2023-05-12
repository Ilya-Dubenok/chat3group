package by.academy.threegroup.controllers.web.servlets;

import by.academy.threegroup.core.UserCreateDTO;
import by.academy.threegroup.service.api.IUserLogUpService;
import by.academy.threegroup.service.factory.UserLogUpServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String CHECK_PASSWORD_PARAM = "checkPassword";
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String SURNAME_PARAM = "surname";
    private static final String DATE_OF_BIRTH_PARAM = "dateOfBirth";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/signUp.jsp");
        requestDispatcher.forward(req, resp);
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
        userLogUpService.save(dto);

//        TODO
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/init.jsp");
        requestDispatcher.forward(req, resp);
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
