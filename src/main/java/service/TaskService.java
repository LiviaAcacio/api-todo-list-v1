package service;

import lombok.RequiredArgsConstructor;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task createTasks(Task task) {
        return repository.save(task);
    }


}
