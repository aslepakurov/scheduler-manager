package ua.kpi.comsys.manager.service;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

import java.lang.reflect.InvocationTargetException;

/**
 * IVelocityServiceImpl Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
@Component
public class VelocityService implements IVelocityService {
    @Autowired
    private VelocityEngine velocityEngine;
    @Override
    public String getGeneratedConfiguration(TastRequestDto taskDto) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                "template/"+ taskDto.getRequestType()+FILE_EXTENSION, "UTF-8", taskDto.toMap());
        return null;
    }
}
