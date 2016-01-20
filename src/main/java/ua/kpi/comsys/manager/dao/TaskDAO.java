package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

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
    public Task create(TastRequestDto taskDto) {
        if (!collectionExist()) {
            LOGGER.info("Created collection for Task.class");
            mongoOperations.createCollection(Task.class);
        }
        String id = UUID.randomUUID().toString();
        Task task = Task.from(taskDto);
        task.setId(id);
        mongoOperations.save(task);
        LOGGER.info(String.format("Saved task with text=%s...", task.getId()));
        return task;
    }

    @Override
    public Task get(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Task.class);
    }

    private boolean collectionExist() {
        return mongoOperations.collectionExists(Task.class);
    }
}
