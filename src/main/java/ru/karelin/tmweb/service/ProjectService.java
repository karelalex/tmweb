package ru.karelin.tmweb.service;

import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.repository.ProjectRepository;

import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository = ProjectRepository.getInstance();
    private static final ProjectService ourInnstance = new ProjectService();
    public static ProjectService getInstance(){
        return ourInnstance;
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
    public void remove(String projectId){
        Project project = projectRepository.find(projectId);
        if (project!=null) projectRepository.remove(project);
    }
}
