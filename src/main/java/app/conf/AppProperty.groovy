package app.conf

import com.google.gson.Gson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperty implements Serializable{

    private static final Logger LOGGER = LoggerFactory.getLogger(AppProperty.class)

    @Autowired
    private transient Gson gson

    @Value('${app.name:Not Available}')
    String appName

    @Value('${app.admin.user:system}')
    String appAdminUser

    @Value('${app.admin.password:system}')
    transient String appAdminPassword

    @Override
    String toString() {
        return gson.toJson(this)
    }

}
