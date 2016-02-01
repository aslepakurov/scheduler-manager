package ua.kpi.comsys.manager.rest;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.dto.TaskResponseDto;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;
import ua.kpi.comsys.manager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * ExampleRest Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@RestController
@RequestMapping("/task")
public class SchedulerManagerRest {
    @Autowired
    private ITaskService taskService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto taskRequest) {
        try {
            Task task = taskService.create(taskRequest);
            return ResponseEntity.ok(TaskResponseDto.to(task));
        } catch (IOException e) {
            return ResponseEntity.ok(new TaskResponseDto());
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TaskResponseDto> get(@PathVariable("id") String id) {
        Task task = taskService.get(id);
        return ResponseEntity.ok(TaskResponseDto.to(task));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(taskService.delete(id));
    }
}