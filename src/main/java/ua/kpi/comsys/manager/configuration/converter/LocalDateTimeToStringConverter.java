package ua.kpi.comsys.manager.configuration.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * LocalDateTimeToStringConverter Class
 *
 * @author aslepakurov
 * @version 01/27/2016
 */
@Component
public class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
    @Override
    public String convert(LocalDateTime localDate) {
        return localDate.toString();
    }
}