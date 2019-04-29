package ru.karelin.tmweb.repository;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.karelin.tmweb.entity.Project;

import java.util.*;

public class ProjectRepository {
    private static final ProjectRepository ourInstance = new ProjectRepository();
    private final Map<String, Project> projectMap = new LinkedHashMap<>();
    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepository() {

    }
    public List<Project> findAll(){
        return new ArrayList<>(projectMap.values());
    }
    public List<Project> findAllByUserId(String userId){return filterByUserId(findAll(), userId);}
    public Project find(String id) {
        for (Project p: projectMap.values()
             ) {
            if(p.getId().equals(id)) return p;
        }
        return null;
    }
    public Project findByIdAndUserId(String id, String userId){
        return filterByUserId(find(id), userId);
    }
    public void save(Project p){
        projectMap.put(p.getId(), p);
    }

    public void remove(@NotNull Project project) {
        projectMap.remove(project.getId());
    }
    private List<Project> filterByUserId(List<Project> projects, String userId) {
        Iterator<Project> iter = projects.iterator();
        while(iter.hasNext()){
            Project p = iter.next();
            if (!p.getUserId().equals(userId)){
                iter.remove();
            }
        }
        return projects;
    }
    @Contract("null, _ -> null")
    @Nullable
    private Project filterByUserId(@Nullable Project project, String userId) {
        if (project!=null && project.getUserId().equals(userId)) return project;
        else return null;
    }
}
