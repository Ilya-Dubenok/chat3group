package by.academy.threegroup.controllers.web.servlets.api;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String currentUserLogin = currentUser.getLogin();

        try{
            List<MessageDTO> messages = MessageServiceFactory.getInstance().get(currentUserLogin);
            PrintWriter writer = resp.getWriter();
            for (MessageDTO message : messages) {
                writer.write(message.getText() + "<br>");
            }
        } catch (IllegalArgumentException e){
            resp.getWriter().write("Error: " + e.getMessage() + ". Please try again");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String senderLogin = currentUser.getLogin();

        String recipientLogin = req.getParameter("recipientLogin");
        String messageText = req.getParameter("messageText");

        String errorMessageParam = "";

        try{
            MessageServiceFactory.getInstance().save(new MessageCreateDTO(senderLogin, recipientLogin,messageText));
        } catch (IllegalArgumentException e) {
            errorMessageParam = "errorMessage=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
        }

        String referer = req.getHeader("referer");
        if(referer.contains("?")){
            referer = referer.substring(0, referer.indexOf("?")+1);
        } else {
            referer = referer + "?";
        }
        resp.sendRedirect(referer + errorMessageParam);
    }
}