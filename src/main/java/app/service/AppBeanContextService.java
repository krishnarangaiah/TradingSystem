package app.service;

import app.error.AppError;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppBeanContextService implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBeanFromContext(Class<T> tClass) {
        return Optional.ofNullable(applicationContext).orElseThrow(()-> new AppError()).getBean(tClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppBeanContextService.applicationContext = applicationContext;
    }

}
