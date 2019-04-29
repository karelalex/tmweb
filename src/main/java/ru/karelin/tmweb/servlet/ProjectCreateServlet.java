package ru.karelin.tmweb.servlet;

import lombok.SneakyThrows;
import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.enumeration.Status;
import ru.karelin.tmweb.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/createproject")
public class ProjectCreateServlet extends HttpServlet {
    private final ProjectService projectService = ProjectService.getInstance();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/create-project.jsp").forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Project project =new Project();
        project.setName(req.getParameter("name"));
        project.setDescription(req.getParameter("desc"));
        project.setStartingDate(dateFormat.parse(req.getParameter("startDate")));
        project.setFinishDate(dateFormat.parse(req.getParameter("finishDate")));
        project.setStatus(Status.PLANNED);
        projectService.save(project);
        resp.sendRedirect(req.getContextPath()+"/showproject?pid="+project.getId());
    }
}
