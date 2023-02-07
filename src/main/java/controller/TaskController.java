package controller;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TaskService;

import java.util.List;
import java.util.Locale;

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

    @GetMapping("/busca-task")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        return service.listAllTask();
    }

    @GetMapping("/busca-task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") long id){
        return service.findTaskById(id);
    }

    @PutMapping("/atualiza-task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
        return service.updateTask(task,id);
    }

    @DeleteMapping("exclui-task")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id){
        return service.deleteById(id);
    }
}
