package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

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
    public String create(Task entity) {
        if (!collectionExist()) {
            LOGGER.info("Created collection for TaskRequest.class");
            mongoOperations.createCollection(Task.class);
        }
        String id = UUID.randomUUID().toString();
        entity.setId(id);
        mongoOperations.save(entity);
        LOGGER.info(String.format("Saved entity with text=%s...", entity.getId()));
        return id;
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
