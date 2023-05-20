package by.academy.threegroup.controllers.web.servlets.ui;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/user/send-message")
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ui/sendMessage.jsp");

        String errorMessage = req.getParameter("errorMessage");
        if (errorMessage != null) {
            req.setAttribute("errorMessage", errorMessage);
        }

        rd.forward(req, resp);
    }
}
