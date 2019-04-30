package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.service.ProjectService;
import ru.karelin.tmweb.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removetask")
public class TaskRemoveServlet extends HttpServlet {
    private final TaskService taskService = TaskService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        taskService.remove(req.getParameter("tid"), (String)req.getSession().getAttribute("userId"));
        resp.sendRedirect(req.getContextPath()+"/showtask");
    }
}
