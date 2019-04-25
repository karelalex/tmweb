package ru.karelin.tmweb.servlet;

import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.enumeration.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/editproject")
public class EditProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("pid");
        Project project = new Project();
        project.setId(projectId);
        project.setName("Project");
        project.setDescription(project.getName() + " description");
        project.setStartingDate(new Date());
        project.setFinishDate(new Date());
        project.setStatus(Status.READY);
        req.setAttribute("project", project);
        req.getRequestDispatcher("WEB-INF/views/edit-project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
