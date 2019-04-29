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

@WebServlet(urlPatterns = "/editproject")
public class ProjectEditServlet extends HttpServlet {
    private final ProjectService projectService = ProjectService.getInstance();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("pid");
       if(projectId==null || projectId.isEmpty()){
           resp.sendError(404, "Необходим id проекта");
           return;
       }
       else {
           Project project = projectService.find(projectId);
           req.setAttribute("project", project);
       }
        req.getRequestDispatcher("WEB-INF/views/edit-project.jsp").forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Project project = projectService.find(req.getParameter("pid"));
        if (project==null){
            resp.sendError(404, "Проект не найден");
            return;
        }
        project.setName(req.getParameter("name"));
        project.setDescription(req.getParameter("desc"));
        project.setStartingDate(dateFormat.parse(req.getParameter("startDate")));
        project.setFinishDate(dateFormat.parse(req.getParameter("finishDate")));
        project.setStatus(Status.valueOf(req.getParameter("status")));
        projectService.save(project);
        resp.sendRedirect(req.getContextPath()+"/showproject");
    }
}
