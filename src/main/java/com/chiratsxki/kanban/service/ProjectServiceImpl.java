package com.chiratsxki.kanban.service;

import com.chiratsxki.kanban.model.Project;
import com.chiratsxki.kanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
