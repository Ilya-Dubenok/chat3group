package by.academy.threegroup.contollers.web.servlets;

import by.academy.threegroup.core.UserLogInDTO;
import by.academy.threegroup.dao.UserDao;
import by.academy.threegroup.service.UserLogInService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {
    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ui/signIn.jsp");
        rd.include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String login = null;
        String password = null;

        Map<String, String[]> param = req.getParameterMap();
        if(param != null) {
            if(param.containsKey(LOGIN_PARAM_NAME)) {
                if(param.get(LOGIN_PARAM_NAME).length == 1) {
                    login = param.get(LOGIN_PARAM_NAME)[0];
                } else {
                    resp.sendError(400);
                }
            } else {
                resp.sendError(400);
            }
            if(param.containsKey(PASSWORD_PARAM_NAME)) {
                if(param.get(PASSWORD_PARAM_NAME).length == 1) {
                    password = param.get(PASSWORD_PARAM_NAME)[0];
                } else {
                    resp.sendError(400);
                }
            } else {
                resp.sendError(400);
            }
        } else {
            resp.sendError(401);
        }

        if(login != null && password != null) {
            try{
                (new UserLogInService(req.getSession(), new UserDao())).logIn(new UserLogInDTO(login, password));
            } catch(IllegalArgumentException e) {
                writer.write("Wrong login or password. Please try again.");
                this.doGet(req, resp);
            }
        } else {
            resp.sendError(401);
        }
    }

}
