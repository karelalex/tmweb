package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.enumeration.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/showproject")
public class ShowProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("pid");
        if (projectId == null || projectId.isEmpty()) {
            List<Project> projects = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Project p = new Project();
                p.setName("Project " + i);
                p.setDescription(p.getName() + " description");
                p.setStartingDate(new Date());
                p.setFinishDate(new Date());
                p.setStatus(Status.PLANNED);
                projects.add(p);
            }
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("WEB-INF/views/project-list.jsp").forward(req, resp);
        } else {
            Project project = new Project();
            project.setId(projectId);
            project.setName("Project");
            project.setDescription(project.getName() + " description");
            project.setStartingDate(new Date());
            project.setFinishDate(new Date());
            project.setStatus(Status.PLANNED);
            req.setAttribute("project", project);
            req.getRequestDispatcher("WEB-INF/views/show-project.jsp").forward(req, resp);
        }

    }
}
