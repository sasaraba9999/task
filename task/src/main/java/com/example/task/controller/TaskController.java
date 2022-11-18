package com.example.task.controller;
import com.example.task.task.CreateTaskForm;
import com.example.task.task.LoginUserHold;
import com.example.task.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/task")
@Controller
@RequiredArgsConstructor    //引数ありコンストラクタ生成でDIを実現　finalかつ初期化されてないコンストラクタを初期化する
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/selectTask/{taskId}")
    public String showTask(@PathVariable("taskId")int taskId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        model.addAttribute("taskList",taskService.findTaskId(taskId,loginName));
        model.addAttribute("id",taskId);
        return "task/selectTask";
    }
    @GetMapping("/contents/{contentId}")
    public String showContent(@PathVariable("contentId")int contentId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        model.addAttribute("content",taskService.findContentId(contentId,loginName));
        return "task/contents";
    }

    @GetMapping("/createTask/{id}")
    //task受け取り
    public String showDeleteForm(@PathVariable("id") int id,@ModelAttribute CreateTaskForm createTaskForm) {
        return "task/createTask";
    }

    @PostMapping("/createTask/{id}")
    public String insert(CreateTaskForm createTaskForm, @PathVariable String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        LoginUserHold loginUserHold = taskService.getuId(loginName);
        int userId = loginUserHold.getLoginuId();
        taskService.create(createTaskForm.getTaskName(),createTaskForm.getContent(),userId, Integer.parseInt(id));
        return "redirect:/";
    }

}