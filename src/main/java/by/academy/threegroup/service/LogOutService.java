package by.academy.threegroup.service;

import jakarta.servlet.http.HttpSession;

public class LogOutService {
   private final HttpSession session;

    public LogOutService(HttpSession session) {
        this.session = session;
    }

    public void logOut() {
        session.setAttribute("user", null);
    }
}
