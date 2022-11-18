package com.example.task.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {

   @Select("select task.taskId ,task.taskName from task,users where task.userId=users.userId and task.projectId=#{taskId} and users.userName=#{loginName}")
    List<TaskEntity> findTaskId(int taskId,String loginName);

   @Select("select content.contentName from content,users where content.userId=users.userId and content.contentId=#{contentId} and users.userName=#{loginName}")
    ContentEntity findContentId(int contentId, String loginName);

    @Insert("insert into task(userId,projectId,taskName) values(#{userId},#{id},#{taskName})")
    void taskCreate(int userId,int id,String taskName);

    @Insert("insert into content(contentName,userId) values(#{content},#{userId})")
    void contentCreate(String content, int userId);

    @Select("select userId from users where userName=#{loginName}")
    LoginUserHold getuId(String loginName);
}