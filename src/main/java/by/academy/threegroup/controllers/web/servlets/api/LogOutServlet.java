package by.academy.threegroup.controllers.web.servlets.api;

import by.academy.threegroup.service.LogOutService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new LogOutService(req.getSession()).logOut();
        resp.sendRedirect(req.getContextPath() + "/ui/");
    }
}
