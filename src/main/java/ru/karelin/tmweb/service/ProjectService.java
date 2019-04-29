package ru.karelin.tmweb.service;

import org.jetbrains.annotations.Nullable;
import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.repository.ProjectRepository;

import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository = ProjectRepository.getInstance();
    private static final ProjectService ourInstance = new ProjectService();
    public static ProjectService getInstance(){
        return ourInstance;
    }
    private ProjectService(){}

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project find(String projectId) {
        return projectRepository.find(projectId);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }
    public void remove(@Nullable String projectId, String userId){
        if(projectId==null || projectId.isEmpty()) return;
        Project project = projectRepository.findByIdAndUserId(projectId, userId);
        if (project!=null) projectRepository.remove(project);
    }

    public List<Project> findAllByUserId(String id) {
       return projectRepository.findAllByUserId(id);
    }

    public Project findByIdAndUserId(String id, String userId) {
        return projectRepository.findByIdAndUserId(id, userId);
    }
}
