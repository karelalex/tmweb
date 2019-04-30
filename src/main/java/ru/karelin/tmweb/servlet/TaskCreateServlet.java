package ru.karelin.tmweb.servlet;

import lombok.SneakyThrows;
import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.entity.Task;
import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.enumeration.Status;
import ru.karelin.tmweb.service.ProjectService;
import ru.karelin.tmweb.service.TaskService;
import ru.karelin.tmweb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = "/createtask")
public class TaskCreateServlet extends HttpServlet {
    private final ProjectService projectService = ProjectService.getInstance();
    private final TaskService taskService = TaskService.getInstance();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User currentUser = userService.find((String)req.getSession().getAttribute("userId"));
        req.setAttribute("user", currentUser);
        List<Project> projects = projectService.findAllByUserId(currentUser.getId());
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("WEB-INF/views/create-task.jsp").forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Task task =new Task();
        final User currentUser = userService.find((String)req.getSession().getAttribute("userId"));
        task.setName(req.getParameter("name"));
        task.setProjectId(req.getParameter("pid"));
        task.setDescription(req.getParameter("desc"));
        task.setStartingDate(dateFormat.parse(req.getParameter("startDate")));
        task.setFinishDate(dateFormat.parse(req.getParameter("finishDate")));
        task.setStatus(Status.PLANNED);
        task.setUserId(currentUser.getId());
        taskService.save(task);
        resp.sendRedirect(req.getContextPath()+"/showtask?tid="+task.getId());
    }
}
