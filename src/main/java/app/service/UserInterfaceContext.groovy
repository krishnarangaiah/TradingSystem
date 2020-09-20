package app.service

import app.conf.AppProperty
import app.dao.model.user.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.servlet.http.HttpSession

@Component
class UserInterfaceContext implements Serializable {

    private static final long serialVersionUID = -3394981889554859781L
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInterfaceContext);

    private static final USER = "USER"
    private static final ACTION_MSG = "ACTION_MSG"
    private static final ERROR_MSG = "ERROR_MSG"
    private static final WARN_MSG = "WARN_MSG"

    @Autowired
    AppProperty appProperty
    transient HttpSession httpSession

    def setSessionUser(User user) {
        if (null != httpSession)
            httpSession.setAttribute(USER, user)
        else
            LOGGER.error "httpSession cannot be null"
    }

    def getSessionUser() {
        if (null != httpSession.getAttribute(USER))
            httpSession.getAttribute(USER)
        else
            return null
    }

    boolean isSessionValid() {
        return null != httpSession
    }

    def setActionMsg(String msg) {
        if (null != httpSession)
            httpSession.setAttribute(ACTION_MSG, msg)
    }

    String getActionMsg() {
        if (null != httpSession)
            return httpSession.getAttribute(ACTION_MSG)
        else
            return null
    }

    def setWarnMsg(String msg) {
        if (null != httpSession)
            httpSession.setAttribute(WARN_MSG, msg)
    }

    String getWarnMsg() {
        if (null != httpSession)
            return httpSession.getAttribute(WARN_MSG)
        else
            return null
    }

    def setErrorMsg(String msg) {
        if (null != httpSession)
            httpSession.setAttribute(ERROR_MSG, msg)
    }

    String getErrorMsg() {
        if (null != httpSession)
            return httpSession.getAttribute(ERROR_MSG)
        else
            return null
    }


}
