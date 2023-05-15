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

@WebServlet("/ui/get-message")
public class GetMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        String currentUserLogin = currentUser.getLogin();

        try{
            List<MessageDTO> messages = MessageServiceFactory.getInstance().get(currentUserLogin);
            req.setAttribute("messages", messages);
            getServletContext().getRequestDispatcher("/ui/getMessage.jsp").forward(req, resp);
        } catch (IllegalArgumentException e){
            resp.getWriter().write("Error: " + e.getMessage() + ". Please try again");
        }
    }
}
