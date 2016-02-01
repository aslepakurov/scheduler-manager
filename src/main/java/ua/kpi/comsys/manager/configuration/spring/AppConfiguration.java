package ua.kpi.comsys.manager.configuration.spring;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.*;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ResourceBundle;

/**
 * AppConfig Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Configuration
@EnableWebMvc
@Import({MongoConfiguration.class, RabbitMqConfiguration.class})
@ComponentScan(basePackages = "ua.kpi.comsys.manager.*")
public class AppConfiguration {

    @Bean
    public VelocityEngine velocityEngine(){
        return new VelocityEngine();
    }

    @Bean
    public ResourceBundle messages() {
        return ResourceBundle.getBundle("messages");
    }
}
