package app.conf;

import app.service.AppBeanContextService;
import app.service.UserInterfaceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AppGlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppGlobalRequestInterceptor.class);
    private final UserInterfaceContext userInterfaceContext = AppBeanContextService.getBeanFromContext(UserInterfaceContext.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (null != request.getSession()) {
            LOGGER.info("SessionId: {}", request.getSession().getId());
        }

        if (null != modelAndView) {
            Map<String, Object> x = modelAndView.getModel();
            x.put("userInterfaceContext", userInterfaceContext);
        }

        super.postHandle(request, response, handler, modelAndView);

    }

}
