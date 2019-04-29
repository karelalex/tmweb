package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login-form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findByLoginAndPassword(req.getParameter("login"), req.getParameter("pass"));
        if (user!=null){
            req.getSession().setAttribute("userId", user.getId());
            resp.sendRedirect(req.getContextPath()+"/");
        }
        else {
            doGet(req, resp);
        }
    }
}
