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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AppGlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppGlobalRequestInterceptor.class);
    private static final String LOGIN_FORM = "/User/LoginForm";
    private static final List<String> ALLOWED_URIS = Arrays.asList(
            "/User/Login",
            LOGIN_FORM,
            "/webjars/bootstrap/4.5.0/css/bootstrap.min.css",
            "/webjars/font-awesome/4.7.0/css/font-awesome.min.css",
            "/webjars/bootstrap/4.5.0/js/bootstrap.min.js",
            "/webjars/jquery/3.5.1/jquery.min.js",
            "/webjars/d3js/5.16.0/d3.min.js",
            "/js/app.js",
            "/css/app.css",
            "/favicon.ico",
            "/error",
            "/webjars/font-awesome/4.7.0/fonts/fontawesome-webfont.woff2",
            "/webjars/font-awesome/4.7.0/fonts/fontawesome-webfont.woff",
            "/webjars/font-awesome/4.7.0/fonts/fontawesome-webfont.ttf",
            "/webjars/font-awesome/4.7.0/fonts/fontawesome-webfont.woff2"
    );
    private final AppProperty appProperty = AppBeanContextService.getBeanFromContext(AppProperty.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // LOGGER.info("PreHandle SessionId: {}, RequestContextPath: {}, RequestURI: {}", request.getSession().getId(), request.getContextPath(), request.getRequestURI());

        HttpSession session = request.getSession();
        if (ALLOWED_URIS.contains(request.getRequestURI())) {
            return super.preHandle(request, response, handler);
        } else if ((null == SessionUtil.getSessionUser(session))
                || (!session.getId().equals(SessionUtil.getSessionUser(session).getSessionId()))) {
            response.sendRedirect(request.getContextPath() + LOGIN_FORM);
            return false;
        } else {
            return super.preHandle(request, response, handler);
        }
        // return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        LOGGER.debug("PostHandle SessionId: {}", request.getSession().getId());

        if (null != modelAndView) {
            Map<String, Object> x = modelAndView.getModel();
            x.put("appProperty", appProperty);
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}
