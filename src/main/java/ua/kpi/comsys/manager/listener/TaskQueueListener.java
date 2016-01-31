package ua.kpi.comsys.manager.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.event.TaskEvent;
import ua.kpi.comsys.manager.service.ITaskService;

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

    @RabbitListener(queues = "taskQueue")
    public void processTaskQueue(TaskEvent taskEvent){
        LOGGER.info("Started processing event with id="+taskEvent.getId());
        taskService.updateStatus(taskEvent.getId(), TaskStatus.PROCESSING);
    }
}
