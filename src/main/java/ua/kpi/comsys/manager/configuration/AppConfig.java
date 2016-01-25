package ua.kpi.comsys.manager.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ua.kpi.comsys.manager.listener.TaskQueueListener;

import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * AppConfig Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.kpi.comsys.manager.*")
@PropertySource("classpath:/db.properties")
public class AppConfig implements InitializingBean{
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);
    @Autowired
    private Environment environment;
    private String dbHost;
    private String dbScheme;

    @Override
    public void afterPropertiesSet() throws Exception {
        dbHost = environment.getProperty("db.host");
        dbScheme = environment.getProperty("db.scheme");
        LOGGER.info(String.format("Database connection (host: %s, scheme:%s)", dbHost, dbScheme));
    }

    @Bean
    public MongoClient mongo() throws UnknownHostException {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(200).build();
        return new MongoClient(dbHost, options);
    }

    @Bean
    public MongoOperations mongoOperations() throws UnknownHostException {
        return new MongoTemplate(mongo(), dbScheme);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue taskQueue() {
        return new Queue("taskQueue");
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(3);
        return factory;
    }

    @Bean
    public ResourceBundle messages() {
        return ResourceBundle.getBundle("messages");
    }
}
