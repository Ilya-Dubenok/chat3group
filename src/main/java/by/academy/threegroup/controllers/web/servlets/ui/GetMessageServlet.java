package by.academy.threegroup.controllers.web.servlets.ui;

import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/ui/user/get-message")
public class GetMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String currentUserLogin = currentUser.getLogin();

        String sender = req.getParameter("sender");
        List<MessageDTO> messages = MessageServiceFactory
                .getInstance()
                .get(currentUserLogin)
                .stream()
                .filter(e -> e.getSenderLogin().equals(sender))
                .collect(Collectors.toList());
        req.setAttribute("messages", messages);

        getServletContext().getRequestDispatcher("/ui/getMessage.jsp").forward(req, resp);
    }
}
