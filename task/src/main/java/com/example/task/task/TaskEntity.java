package com.example.task.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskEntity {
    private int taskId;
    private String taskName;
}
