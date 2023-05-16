package by.academy.threegroup.controllers.web.filters;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session != null) && (session.getAttribute("user") != null)) {
            UserDTO dto = (UserDTO) session.getAttribute("user");
            if(dto.getRole() == UserRoles.ADMIN) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                res.sendRedirect(contextPath + "/ui/");
            }
        } else {
            res.sendRedirect(contextPath + "/ui/login");
        }
    }
}
