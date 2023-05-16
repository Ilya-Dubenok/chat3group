package by.academy.threegroup.controllers.web.servlets.api;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import by.academy.threegroup.service.api.IStatisticService;
import by.academy.threegroup.service.factory.StatisticsServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    IStatisticService statisticService = StatisticsServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null) {

            UserDTO user = (UserDTO) session.getAttribute("user");

            if (user != null && user.getRole().equals(UserRoles.ADMIN)) {
                PrintWriter writer = resp.getWriter();
                int countOfActiveUsers = statisticService.getCountOfActiveUsers();
                int countOfRegisteredUsers = statisticService.getCountOfRegisteredUsers();
                int countOfMessages = statisticService.getCountOfMessages();

                //TODO ПЕРЕПИСАТЬ НА JSP СТРАНИЦУ
                writer.write("активных пользователей: " + countOfActiveUsers + " сообщений: " + countOfMessages +
                        " всего зарегистрировано пользователей: " + countOfRegisteredUsers);
                return;

            }

        }

        req.getRequestDispatcher("/ui/").forward(req, resp);




    }
}
