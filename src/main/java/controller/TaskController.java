package controller;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task crateTask(@RequestBody Task task){
        return service.createTasks(task);
    }
}
