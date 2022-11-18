package com.example.task.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //ビジネスロジック層　&　Bean登録
@RequiredArgsConstructor    //Lombokでコンストラクタ生成
public class ProjectService {

    private final ProjectRepository projectRepository;
    public List<ProjectEntity> findProjectName(String loginName) {

        return projectRepository.findProjectName(loginName);
    }

    public void create(String projectName) {
        projectRepository.insert(projectName);

    }

    public void change(String projectOldName, String projectName) {
        projectRepository.update(projectOldName,projectName);
    }

    public void delete(String projectId) {
        projectRepository.delete(Integer.parseInt(projectId));
    }
}
