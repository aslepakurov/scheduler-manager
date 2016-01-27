package ua.kpi.comsys.manager.configuration.spring;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ua.kpi.comsys.manager.configuration.converter.LocalDateTimeToStringConverter;
import ua.kpi.comsys.manager.configuration.converter.StringToLocalDateTimeConverter;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * MongoConfiguration Class
 *
 * @author aslepakurov
 * @version 01/27/2016
 */
@EnableMongoRepositories(basePackages = {"ua.kpi.comsys.manager.configuration.spring"})
@PropertySource("classpath:/db.properties")
public class MongoConfiguration extends AbstractMongoConfiguration implements InitializingBean {
    private static final Logger LOGGER = Logger.getLogger(MongoConfiguration.class);

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

    @Override
    protected String getDatabaseName() {
        return dbScheme;
    }

    @Override
    public MongoClient mongo() throws UnknownHostException {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(200).build();
        return new MongoClient(dbHost, options);
    }

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(
                Arrays.asList(new LocalDateTimeToStringConverter(),
                        new StringToLocalDateTimeConverter()));
    }


}
