package com.chiratsxki.kanban.service;

import com.chiratsxki.kanban.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    Project createProject(Project project);
}
