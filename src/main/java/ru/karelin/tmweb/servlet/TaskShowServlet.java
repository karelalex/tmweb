package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.Task;
import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.service.TaskService;
import ru.karelin.tmweb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/showtask")
public class TaskShowServlet extends HttpServlet {
    private final TaskService taskService = TaskService.getInstance();
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("tid");
        String projectId = req.getParameter("pid");
        User currentUser = userService.find((String)req.getSession().getAttribute("userId"));
        req.setAttribute("user", currentUser);
        if(taskId==null || taskId.isEmpty()){
            List<Task> tasks;
            if(projectId==null || projectId.isEmpty()){
                tasks = taskService.findAllByUserId(currentUser.getId());
            }
            else {
                tasks = taskService.findAllByUserIdAndProjectId(currentUser.getId(), projectId);
            }
            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("WEB-INF/views/task-list.jsp").forward(req, resp);
        }
        else {
            Task task = taskService.findByIdAndUserId(taskId, currentUser.getId());
            req.setAttribute("task", task);
            req.getRequestDispatcher("WEB-INF/views/show-task.jsp").forward(req, resp);
        }
    }
}
