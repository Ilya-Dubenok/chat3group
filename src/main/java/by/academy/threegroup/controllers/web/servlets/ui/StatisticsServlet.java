package by.academy.threegroup.controllers.web.servlets.ui;

import by.academy.threegroup.service.api.IStatisticService;
import by.academy.threegroup.service.factory.StatisticsServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    IStatisticService statisticService = StatisticsServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int countOfActiveUsers = statisticService.getCountOfActiveUsers();
        int countOfRegisteredUsers = statisticService.getCountOfRegisteredUsers();
        int countOfMessages = statisticService.getCountOfMessages();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/admin/statistics.jsp");
        req.setAttribute("activeUsers", countOfActiveUsers);
        req.setAttribute("messages", countOfMessages);
        req.setAttribute("registeredUsers", countOfRegisteredUsers);

        requestDispatcher.forward(req, resp);

    }
}
