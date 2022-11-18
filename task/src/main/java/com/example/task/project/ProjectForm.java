package com.example.task.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
public class ProjectForm {
    public int projectId;
    public String projectName;
}
