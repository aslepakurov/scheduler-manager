package ua.kpi.comsys.manager.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import ua.kpi.comsys.manager.configuration.spring.AppConfiguration;
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
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("id", "1");
        return writeContextToTemplate("template/pbs.vm", velocityContext);
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
