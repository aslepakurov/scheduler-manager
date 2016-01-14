package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.TaskRequest;
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
public class TaskRequestDAO implements ITaskRequestDAO {
    private static final Logger LOGGER = Logger.getLogger(TaskRequestDAO.class);

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public String create(TaskRequest entity) {
        if (!collectionExist()) {
            LOGGER.info("Created collection for TaskRequest.class");
            mongoOperations.createCollection(TaskRequest.class);
        }
        String id = UUID.randomUUID().toString();
        entity.setId(id);
        mongoOperations.save(entity);
        LOGGER.info(String.format("Saved entity with text=%s...", entity.getText()));
        return id;
    }

    @Override
    public TaskRequest get(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, TaskRequest.class);
    }

    private boolean collectionExist() {
        return mongoOperations.collectionExists(TaskRequest.class);
    }
}
