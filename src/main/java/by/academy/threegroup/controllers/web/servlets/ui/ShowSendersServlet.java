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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@WebServlet("/ui/user/show-senders")
public class ShowSendersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String currentUserLogin = currentUser.getLogin();

        List<MessageDTO> messages = MessageServiceFactory.getInstance().get(currentUserLogin);

        if (messages != null){
            Set<String> senders = new HashSet<>();
            for (MessageDTO message : messages) {
                senders.add(message.getSenderLogin());
            }
            req.setAttribute("senders", senders);
        }

        getServletContext().getRequestDispatcher("/ui/showSenders.jsp").forward(req, resp);
    }
}
