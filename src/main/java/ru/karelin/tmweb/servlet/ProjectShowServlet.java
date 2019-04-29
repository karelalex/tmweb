package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.service.ProjectService;
import ru.karelin.tmweb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/showproject")
public class ProjectShowServlet extends HttpServlet {
    private final ProjectService projectService = ProjectService.getInstance();
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("pid");
        User currentUser = userService.find((String)req.getSession().getAttribute("userId"));
        req.setAttribute("user", currentUser);
        if (projectId == null || projectId.isEmpty()) {
            List<Project> projects = projectService.findAllByUserId(currentUser.getId());
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("WEB-INF/views/project-list.jsp").forward(req, resp);
        } else {
            Project project = projectService.findByIdAndUserId(projectId, currentUser.getId());
            req.setAttribute("project", project);
            req.getRequestDispatcher("WEB-INF/views/show-project.jsp").forward(req, resp);
        }

    }
}
