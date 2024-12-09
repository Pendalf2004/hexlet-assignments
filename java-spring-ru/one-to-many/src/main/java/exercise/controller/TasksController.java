package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping("")
    public List<TaskDTO> index() {
        return taskRepository.findAll().stream()
                .map(task -> taskMapper.map(task))
                .toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found");
        }
        taskRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NotFound"));
        return taskMapper.map(task);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO taskData) {
        var newTask = taskMapper.map(taskData);
        taskRepository.save(newTask);
        return taskMapper.map(newTask);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable Long id, @RequestBody @Valid TaskUpdateDTO updateData) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NotFound"));
        taskMapper.update(updateData, task);
        task.setAssignee(userRepository.getReferenceById(updateData.getAssigneeId()));
        taskRepository.save(task);
        var taskDTO = taskMapper.map(task);
        return taskDTO;
    }
    // END
}
