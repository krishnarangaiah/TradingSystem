package app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(["app.conf", "app.http", "app.dao", "app.service"])
class AppConf {}