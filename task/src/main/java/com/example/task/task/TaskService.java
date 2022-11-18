package com.example.task.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //ビジネスロジック層　&　Bean登録
@RequiredArgsConstructor    //Lombokでコンストラクタ生成
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskEntity> findTaskId(int taskId, String loginName) {
        return taskRepository.findTaskId(taskId,loginName);
    }

    public ContentEntity findContentId(int contentId, String loginName) {
        return taskRepository.findContentId(contentId,loginName);
    }

    public void create(String taskName, String content,int userId,int id) {
        taskRepository.taskCreate(userId, id, taskName);
        taskRepository.contentCreate(content,userId);
    }

    public LoginUserHold getuId(String loginName) {
       return taskRepository.getuId(loginName);
    }
}
