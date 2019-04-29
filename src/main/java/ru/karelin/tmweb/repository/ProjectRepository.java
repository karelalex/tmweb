package ru.karelin.tmweb.repository;

import org.jetbrains.annotations.NotNull;
import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.enumeration.Status;

import java.util.*;

public class ProjectRepository {
    private static final ProjectRepository ourInstance = new ProjectRepository();
    private final Map<String, Project> projectMap = new LinkedHashMap<>();
    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepository() {
        for (int i = 0; i < 10; i++) {
            Project p = new Project();
            p.setName("Project " + i);
            p.setDescription(p.getName() + " description");
            p.setStartingDate(new Date());
            p.setFinishDate(new Date());
            p.setStatus(Status.PLANNED);
            projectMap.put(p.getId(), p);
        }
    }
    public List<Project> findAll(){
        return new ArrayList<>(projectMap.values());
    }
    public Project find(String projectId) {
        for (Project p: projectMap.values()
             ) {
            if(p.getId().equals(projectId)) return p;
        }
        return null;
    }
    public void save(Project p){
        projectMap.put(p.getId(), p);
    }

    public void remove(@NotNull Project project) {
        projectMap.remove(project.getId());
    }
}
