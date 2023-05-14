package by.academy.threegroup.controllers.web.servlets.ui;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/")
public class WelcomePageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (null != session) {

            req.setAttribute("user", session.getAttribute("user"));

        } else {
            req.setAttribute("user", null);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/ui/welcome.jsp");

        dispatcher.forward(req, resp);


    }
}
