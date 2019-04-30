package ru.karelin.tmweb.servlet;


import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.entity.Task;
import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.enumeration.Status;
import ru.karelin.tmweb.repository.*;
import ru.karelin.tmweb.service.UserService;
import ru.karelin.tmweb.util.MD5Generator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    public void init() throws ServletException {
        //register user
        User user = new User();
        user.setLogin("sk");
        user.setPassHash(MD5Generator.generate("skPass"));
        user.setUsername("Саня");
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.save(user);
        ProjectRepository projectRepository = ProjectRepositoryImpl.getInstance();
        TaskRepository taskRepository = TaskRepositoryImpl.getInstance();
        for (int i = 0; i < 10; i++) {
            Project p = new Project();
            p.setName("Проект " + i);
            p.setDescription(p.getName() + " очень интересное описание");
            p.setStartingDate(new Date());
            p.setFinishDate(new Date());
            p.setStatus(Status.PLANNED);
            p.setUserId(user.getId());
            projectRepository.save(p);
            for(int j = 0; j<9; j++) {
                Task t = new Task();
                t.setName("Задача" +j);
                t.setDescription(t.getName() + " классное описание");
                t.setStartingDate(new Date());
                t.setFinishDate(new Date());
                t.setStatus(Status.PLANNED);
                t.setUserId(user.getId());
                t.setProjectId(p.getId());
                taskRepository.save(t);
            }
        }
        User user2 = new User();
        user2.setLogin("bb");
        user2.setPassHash(MD5Generator.generate("bbPass"));
        user2.setUsername("Боря");
        userRepository.save(user2);
        for (int i = 0; i < 10; i++) {
            Project p = new Project();
            p.setName("Проектус " + i);
            p.setDescription(p.getName() + " так себе описание");
            p.setStartingDate(new Date());
            p.setFinishDate(new Date());
            p.setStatus(Status.PLANNED);
            p.setUserId(user2.getId());
            projectRepository.save(p);
            for(int j = 0; j<3; j++) {
                Task t = new Task();
                t.setName("Задачаща" +j);
                t.setDescription(t.getName() + " классное и хреновое описание");
                t.setStartingDate(new Date());
                t.setFinishDate(new Date());
                t.setStatus(Status.PLANNED);
                t.setUserId(user2.getId());
                t.setProjectId(p.getId());
                taskRepository.save(t);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User currentUser = userService.find((String)req.getSession().getAttribute("userId"));
        req.setAttribute("user", currentUser);
        req.getRequestDispatcher("WEB-INF/views/welcome-page.jsp").forward(req, resp);
    }
}
