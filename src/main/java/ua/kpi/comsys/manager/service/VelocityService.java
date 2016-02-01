package ua.kpi.comsys.manager.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * VelocityService Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
@Component
public class VelocityService implements IVelocityService {

    @Override
    public String getGeneratedConfiguration(TaskRequestDto taskDto) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
//        properties.setProperty("resource.loader", "webapp");
//        properties.setProperty("resource.loader", "class");
        properties.setProperty("resource.loader", "file");
//        properties.setProperty("class.resource.loader.class", "org.apache.velocity.tools.view.WebappResourceLoader");
//        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        properties.setProperty("class.resource.loader.path", "/tmp/template");
        properties.setProperty("class.resource.loader.cache", "false");
        properties.setProperty("runtime.log", "/tmp/velocity.log");
        Velocity.init(properties);
//        Template template = Velocity.getTemplate(taskDto.getRequestType() + FILE_EXTENSION);
        Template template = Velocity.getTemplate("pbs.vm");
        VelocityContext velocityContext = new VelocityContext(taskDto.toMap());
        StringWriter sw = new StringWriter();
        template.merge(velocityContext,  sw);
        return sw.toString();
    }
}
