package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;

import java.lang.reflect.InvocationTargetException;

/**
 * IVelocityService Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
public interface IVelocityService {
    String FILE_EXTENSION = ".vm";
    String getGeneratedConfiguration(TaskRequestDto task) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
