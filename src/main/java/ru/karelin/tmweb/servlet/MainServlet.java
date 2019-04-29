package ru.karelin.tmweb.servlet;


import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.repository.UserRepository;
import ru.karelin.tmweb.util.MD5Generator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //register user
        User user = new User();
        user.setLogin("sk");
        user.setPassHash(MD5Generator.generate("skPass"));
        user.setUsername("Саня");
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.save(user);
            }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/welcome-page.jsp").forward(req,resp);
    }
}
