package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

public class AppInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppInit.class);

    public static void main(String[] args) {

        LOGGER.info("Application Starting");
        SpringApplication.run(AppConf.class, args);
        LOGGER.info("-----------------------------------");
        LOGGER.info("Application is Started successfully");
        LOGGER.info("-----------------------------------");
    }

}
