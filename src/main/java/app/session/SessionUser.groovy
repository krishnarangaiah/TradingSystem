package app.session

import app.dao.model.user.User

class SessionUser implements Serializable {

    private static final long serialVersionUID = -3394981889554859781L

    String sessionId
    User user
    SessionMsgType msgType
    String msg
}

enum SessionMsgType {
    ACTION, WARN, ERROR
}