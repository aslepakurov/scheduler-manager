package ua.kpi.comsys.manager.dao;

import org.springframework.data.mongodb.core.query.Update;
import ua.kpi.comsys.manager.domain.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * ExampleDAO Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Component
public class TaskDAO implements ITaskDAO {
    private static final Logger LOGGER = Logger.getLogger(TaskDAO.class);

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Task create(Task task) {
        if (!collectionExist()) {
            LOGGER.info("Created collection for Task.class");
            mongoOperations.createCollection(Task.class);
        }
        String id = UUID.randomUUID().toString();
        task.setId(id);
//        task.setCreationDate(LocalDateTime.now());
        task.setStatus(TaskStatus.SUBMITED);
        mongoOperations.save(task);
        LOGGER.info(String.format("Saved task with id=%s...", task.getId()));
        return task;
    }

    @Override
    public void save(Task task) {
        mongoOperations.save(task);
    }

    @Override
    public Task get(String id) {
        LOGGER.info(String.format("Getting task with id=%s", id));
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Task.class);
    }

    @Override
    public String delete(String id) {
        LOGGER.info(String.format("Deleting task with id=%s", id));
        Query query = new Query(Criteria.where("id").is(id));
        Task task = mongoOperations.findAndRemove(query, Task.class);
        return task != null ? task.getName() : null;
    }

    @Override
    public void updateStatus(String id, TaskStatus newStatus) {
        Query query = new Query(Criteria.where("id").is(id));
        Task task = mongoOperations.findOne(query, Task.class);
        if (task != null) {
            mongoOperations.updateFirst(query, Update.update("status", newStatus), Task.class);
            LOGGER.info(String.format("Updated task with id=%s. Old status - %s, new status - %s", id, task.getStatus(), newStatus));
        }
    }

    private boolean collectionExist() {
        return mongoOperations.collectionExists(Task.class);
    }
}
