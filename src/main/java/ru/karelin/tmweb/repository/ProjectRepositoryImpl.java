package ru.karelin.tmweb.repository;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.karelin.tmweb.entity.Project;

import java.util.*;

public class ProjectRepositoryImpl implements ProjectRepository {
    private static final ProjectRepository ourInstance = new ProjectRepositoryImpl();
    private final Map<String, Project> projectMap = new LinkedHashMap<>();

    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepositoryImpl() {

    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projectMap.values());
    }

    @Override
    public List<Project> findAllByUserId(String userId) {
        return filterByUserId(findAll(), userId);
    }

    @Override
    public Project find(String id) {
        return projectMap.get(id);
    }

    @Override
    public Project findByIdAndUserId(String id, String userId) {
        return filterByUserId(find(id), userId);
    }

    @Override
    public void save(Project p) {
        projectMap.put(p.getId(), p);
    }

    @Override
    public void remove(@NotNull Project project) {
        projectMap.remove(project.getId());
    }

    private List<Project> filterByUserId(List<Project> projects, String userId) {
        Iterator<Project> iter = projects.iterator();
        while (iter.hasNext()) {
            Project p = iter.next();
            if (!p.getUserId().equals(userId)) {
                iter.remove();
            }
        }
        return projects;
    }

    @Contract("null, _ -> null")
    @Nullable
    private Project filterByUserId(@Nullable Project project, String userId) {
        if (project != null && project.getUserId().equals(userId)) return project;
        else return null;
    }
}
