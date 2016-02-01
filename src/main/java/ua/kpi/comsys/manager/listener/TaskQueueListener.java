package ua.kpi.comsys.manager.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;
import ua.kpi.comsys.manager.domain.event.TaskEvent;
import ua.kpi.comsys.manager.service.ITaskFileManagerService;
import ua.kpi.comsys.manager.service.ITaskService;
import ua.kpi.comsys.manager.service.IVelocityService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * TaskQueueListener Class
 *
 * @author aslepakurov
 * @version 01/21/2016
 */
@EnableRabbit
@Component
public class TaskQueueListener {
    private static final Logger LOGGER = Logger.getLogger(TaskQueueListener.class);

    @Autowired
    private ITaskService taskService;
    @Autowired
    private IVelocityService velocityService;
    @Autowired
    private ITaskFileManagerService taskFileManagerService;

    @RabbitListener(queues = "taskQueue")
    public void processTaskQueue(TaskEvent taskEvent){
        LOGGER.info("Started processing event with id="+taskEvent.getId());
        taskService.updateStatus(taskEvent.getId(), TaskStatus.PROCESSING);
        TaskRequestDto dto = TaskRequestDto.to(taskService.get(taskEvent.getId()));
        try {
            String generatedConfiguration = velocityService.getGeneratedConfiguration(dto);
            taskFileManagerService.generateFile(taskEvent.getId(), generatedConfiguration);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | IOException e) {
            LOGGER.error(String.format("Task with id=%s failed to process. Error: %s", taskEvent.getId(), e.getMessage()));
            taskService.updateStatus(taskEvent.getId(), TaskStatus.ERROR);
        }
    }
}
