package app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(["app.core", "app.web", "app.dao"])
class AppConf {}