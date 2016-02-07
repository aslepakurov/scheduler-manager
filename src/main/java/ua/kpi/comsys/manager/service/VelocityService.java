package ua.kpi.comsys.manager.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/**
 * VelocityService Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
@Component
public class VelocityService implements IVelocityService {

    @Autowired
    private VelocityEngine velocityEngine;

    @Override
    public String getGeneratedConfiguration(TaskRequestDto taskDto) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        VelocityContext velocityContext = new VelocityContext(taskDto.toMap());
        return writeContextToTemplate(String.format("template/%s.vm", taskDto.getRequestType()), velocityContext);
    }

    protected String writeContextToTemplate(String templateLocation, VelocityContext context) {
        String body;
        Template t = velocityEngine.getTemplate(templateLocation);
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        body = writer.toString();
        return body;
    }

}
