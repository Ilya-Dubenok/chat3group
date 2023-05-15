package by.academy.threegroup.controllers.web.servlets.ui;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/signup")
public class SignUpServlet extends HttpServlet {

    private static final String CONTEXT_PATH_PARAM = "path";
    private static final String EXCEPTION_MESSAGE_PARAM = "exceptionMessage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/signUp.jsp");

        String path = req.getContextPath();
        req.setAttribute(CONTEXT_PATH_PARAM, path);

        String exceptionMessage = req.getParameter(EXCEPTION_MESSAGE_PARAM);
        if (exceptionMessage != null) {
            req.setAttribute(EXCEPTION_MESSAGE_PARAM, exceptionMessage);
        }

        requestDispatcher.forward(req, resp);
    }
}
