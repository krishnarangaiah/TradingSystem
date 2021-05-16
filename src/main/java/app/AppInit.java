package app;

import app.conf.AppProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class AppInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppInit.class);

    public static void main(String[] args) {

        LOGGER.info("Application Starting");
        ConfigurableApplicationContext appContext = SpringApplication.run(AppConf.class, args);
        LOGGER.info("-----------------------------------");
        LOGGER.info("Application is Started successfully");
        LOGGER.info("-----------------------------------");
        AppProperty appProperty = appContext.getBean(AppProperty.class);
        LOGGER.info("Application is started with {}: {}", appProperty.getClass().getName(), appProperty);

    }

}
