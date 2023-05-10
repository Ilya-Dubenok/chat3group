package by.academy.threegroup.contollers.web.servlets;

import by.academy.threegroup.service.LogOutService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new LogOutService(req.getSession()).logOut();

        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
        rd.include(req, resp);
    }
}
