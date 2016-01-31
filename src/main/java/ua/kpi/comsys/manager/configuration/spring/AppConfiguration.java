package ua.kpi.comsys.manager.configuration.spring;

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
    public VelocityEngineFactoryBean velocityEngine(){
        return new VelocityEngineFactoryBean();
    }

    @Bean
    public ResourceBundle messages() {
        return ResourceBundle.getBundle("messages");
    }
}
