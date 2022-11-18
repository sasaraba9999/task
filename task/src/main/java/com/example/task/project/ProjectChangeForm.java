package com.example.task.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectChangeForm {
    private String projectOldName;
    private String projectName;
}
