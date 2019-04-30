package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.service.UserService;
import ru.karelin.tmweb.util.MD5Generator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/reg-form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login").trim());
        user.setUsername(req.getParameter("userName").trim());
        String pass = req.getParameter("pass").trim();
        String passRepeat = req.getParameter("passRepeat").trim();
        if(user.getLogin().isEmpty() || user.getUsername().isEmpty() || pass.isEmpty() || passRepeat.isEmpty()){
            req.setAttribute("message", "Все поля обязательны к заполнению");
            req.setAttribute("tempuser", user);
            doGet(req, resp);
            return;
        }
        if(userService.checkLogin(user.getLogin())){
            req.setAttribute("message", "Такой логин занят, выберете другой");
            req.setAttribute("tempuser", user);
            doGet(req, resp);
            return;
        }
        if(!req.getParameter("pass").equals(req.getParameter("passRepeat"))) {
            req.setAttribute("message", "Пароли не совпадают, попробуйте ввести ещё раз");
            req.setAttribute("tempuser", user);
            doGet(req, resp);
        }
        else {
            user.setPassHash(MD5Generator.generate(req.getParameter("pass")));
            userService.save(user);
            resp.sendRedirect(req.getContextPath());

        }

    }
}
