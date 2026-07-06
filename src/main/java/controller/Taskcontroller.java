package controller;

import entity.Task;
import org.springframework.web.bind.annotation.*;
import service.Taskservice;
import java.util.Optional;
import java.util.List;

@RequestMapping("/task")
@RestController
public class Taskcontroller {
    private final Taskservice service;

    public Taskcontroller(Taskservice service) {

        this.service = service;
    }
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }
    @GetMapping
    public List<Task> getAllTask() {
        return service.getAllTask();
    }
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id,
                             @RequestBody Task task) {

        task.setId(id);

        return service.updateTask(task);
    }
}