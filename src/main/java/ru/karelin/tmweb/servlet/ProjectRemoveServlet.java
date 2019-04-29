package ru.karelin.tmweb.servlet;

import org.jetbrains.annotations.Nullable;
import ru.karelin.tmweb.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeproject")
public class ProjectRemoveServlet extends HttpServlet {
    ProjectService projectService = ProjectService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        projectService.remove(req.getParameter("pid"), (String)req.getSession().getAttribute("userId"));
        resp.sendRedirect(req.getContextPath()+"/showproject");
    }
}
