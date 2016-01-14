package ua.kpi.comsys.manager.rest;

import ua.kpi.comsys.manager.domain.TaskRequest;
import ua.kpi.comsys.manager.domain.rest.TaskRequestRestResponse;
import ua.kpi.comsys.manager.service.ITaskRequestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ExampleRest Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@RestController
@RequestMapping("/rest")
public class SchedulerManagerRest {
    private static final Logger LOGGER = Logger.getLogger(SchedulerManagerRest.class);

    @Autowired
    private ITaskRequestService exampleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody TaskRequestRestResponse entity) {
        String id = exampleService.create(new TaskRequest(entity.getText()));
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TaskRequest> get(@PathVariable("id") String id) {
        TaskRequest entity = exampleService.get(id);
        return ResponseEntity.ok(entity);
    }

}