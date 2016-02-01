package ua.kpi.comsys.manager.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ua.kpi.comsys.manager.dao.ITaskDAO;
import ua.kpi.comsys.manager.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;
import ua.kpi.comsys.manager.domain.event.TaskEvent;

import java.io.IOException;

/**
 * TaskService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Transactional
@Component
public class TaskService implements ITaskService {

    @Autowired
    private ITaskDAO dao;
    @Autowired
    private ITaskFileManagerService taskFileManagerService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Task create(TaskRequestDto taskDto) throws IOException {
        Task task = TaskRequestDto.from(taskDto);
        task = dao.create(task);
        if (StringUtils.hasText(taskDto.getScript())) {
            taskFileManagerService.saveScriptFile(task.getId(), taskDto.getScript());
        }
        if (StringUtils.hasText(taskDto.getPreRunScript())) {
            taskFileManagerService.saveScriptFile(task.getId(), taskDto.getPreRunScript());
        }
        if (StringUtils.hasText(taskDto.getPostRunScript())) {
            taskFileManagerService.saveScriptFile(task.getId(), taskDto.getPostRunScript());
        }
        rabbitTemplate.convertAndSend("taskQueue", new TaskEvent(task.getId()));
        return task;
    }

    public Task get(String id) {
        return dao.get(id);
    }

    @Override
    public String delete(String id) {
        return dao.delete(id);
    }

    @Override
    public void updateStatus(String id, TaskStatus newStatus) {
        dao.updateStatus(id, newStatus);
    }
}
