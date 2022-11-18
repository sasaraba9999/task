package com.example.task.project;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Select("select projectMember.projectId , projectName from project,projectMember,users where project.projectId=projectMember.projectId and users.userId=projectMember.userId and users.userName=#{loginName}")
    List<ProjectEntity> findProjectName(String loginName);

   @Insert("insert into projects(projectName) values(#{projectName})")
    void insert(String projectName);

   @Update("update project set projectName=#{projectName} where projectName=#{projectOldName}")
    void update(String projectOldName,String projectName);

   @Delete("delete from projectMember where projectId=#{projectId}")
    void delete(int projectId);
}