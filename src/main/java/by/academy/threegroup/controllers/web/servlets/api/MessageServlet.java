package by.academy.threegroup.controllers.web.servlets.api;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.service.factory.MessageServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ui/message.jsp");
        rd.include(req, resp);

        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String currentUserLogin = currentUser.getLogin();

        List<MessageDTO> messages = MessageServiceFactory.getInstance().get(currentUserLogin);
        //todo передать в jsp для вывода
        PrintWriter writer = resp.getWriter();
        for (MessageDTO message : messages) {
            writer.write(message.getText());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String senderLogin = currentUser.getLogin();*/

        String senderLogin = "Alex";

        String recipientLogin = req.getParameter("recipientLogin");
        String messageText = req.getParameter("messageText");

        MessageServiceFactory.getInstance().save(new MessageCreateDTO(senderLogin, recipientLogin,messageText));
    }
}