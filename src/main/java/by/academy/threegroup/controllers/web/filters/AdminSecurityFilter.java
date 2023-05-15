package by.academy.threegroup.controllers.web.filters;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/user/*", "/api/message"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session != null) && (session.getAttribute("user") != null)) {
            //…напишите проверку, что пользователь является админом
            UserDTO dto = (UserDTO) session.getAttribute("user");
            if(dto.getRole() == UserRoles.ADMIN) {
                req.setAttribute("role", UserRoles.ADMIN);
            } else {
                req.setAttribute("role", UserRoles.USER);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //редирект на логин
            res.sendRedirect(contextPath + "/ui/login");
        }
    }
}
