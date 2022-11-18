package com.example.task.controller;
import com.example.task.project.ProjectChangeForm;
import com.example.task.project.ProjectDeleteForm;
import com.example.task.project.ProjectForm;
import com.example.task.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor    //引数ありコンストラクタ生成でDIを実現　finalかつ初期化されてないコンストラクタを初期化する
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/")
    public String showList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();//ログイン中のユーザ取得
        model.addAttribute("projectList",projectService.findProjectName(loginName));
        return "/projects/selectProject";
    }

    @GetMapping("/projects/changeProject")
    public String showChangeForm(@ModelAttribute ProjectChangeForm projectChangeForm) {
        return "/projects/changeProject";
    }

    @GetMapping("/projects/deleteProject")
    public String showDeleteForm(@ModelAttribute ProjectDeleteForm projectDeleteForm) {
        return "/projects/deleteProject";
    }

    @GetMapping("/projects/createProject")
    public String showCreateProject(@ModelAttribute ProjectForm form) {
        return "/projects/createProject";
    }

    @PostMapping("/projects/changeProject")
    public String change(ProjectChangeForm projectChangeForm) {
        projectService.change(projectChangeForm.getProjectOldName(),projectChangeForm.getProjectName());
        return "redirect:/";
    }

    @PostMapping("/projects/deleteProject")
    public String delete(ProjectDeleteForm projectDeleteForm) {
        projectService.delete(projectDeleteForm.getProjectId());
        return "redirect:/";
    }

}