package com.example.task.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTaskForm {
    private String taskName;
    private String content;
}
