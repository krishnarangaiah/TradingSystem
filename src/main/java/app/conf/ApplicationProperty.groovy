package app.conf

import com.google.gson.Gson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
public class ApplicationProperty {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperty.class);

    @Autowired
    private transient Gson gson;

    @Value('${app.name:Not Available}')
    String appName;

    @Override
    public String toString() {
        return gson.toJson(this);
    }

}
