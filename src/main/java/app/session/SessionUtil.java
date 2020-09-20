package app.session;

import app.dao.model.user.User;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    private static final String ACTION_MSG = "ACTION_MSG";
    private static final String WARN_MSG = "WARN_MSG";
    private static final String ERROR_MSG = "ERROR_MSG";

    private static final String USER = "USER";

    public static boolean isSessionNew(HttpSession session) {
        return session.isNew();
    }

    public static void setSessionUser(HttpSession session, User user) {
        session.setAttribute(USER, user);
    }

    public static User getSessionUser(HttpSession session) {
        return (User) session.getAttribute(USER);
    }

    public static void setActionMsg(HttpSession session, String msg) {
        session.setAttribute(ACTION_MSG, msg);
    }

    public static String getActionMsg(HttpSession session) {
        return (String) session.getAttribute(ACTION_MSG);
    }

}
