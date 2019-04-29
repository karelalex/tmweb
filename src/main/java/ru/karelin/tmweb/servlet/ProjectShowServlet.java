package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.service.ProjectService;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("pid");
        if (projectId == null || projectId.isEmpty()) {
            List<Project> projects = projectService.findAll();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("WEB-INF/views/project-list.jsp").forward(req, resp);
        } else {
            Project project = projectService.find(projectId);
            req.setAttribute("project", project);
            req.getRequestDispatcher("WEB-INF/views/show-project.jsp").forward(req, resp);
        }

    }
}
