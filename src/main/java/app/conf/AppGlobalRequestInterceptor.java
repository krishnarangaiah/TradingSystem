package app.conf;

import app.service.AppBeanContextService;
import app.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class AppGlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppGlobalRequestInterceptor.class);
    private final AppProperty appProperty = AppBeanContextService.getBeanFromContext(AppProperty.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.info("PreHandle SessionId: {}, RequestURI: {}", request.getSession().getId(), request.getRequestURI());

        HttpSession session = request.getSession();
        if (null == SessionUtil.getSessionUser(session) && !request.getRequestURI().equals("/LoginForm")) {
            response.sendRedirect("/LoginForm");
            return false;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        LOGGER.info("PostHandle SessionId: {}", request.getSession().getId());

        if (null != modelAndView) {
            Map<String, Object> x = modelAndView.getModel();
            x.put("appProperty", appProperty);
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}
