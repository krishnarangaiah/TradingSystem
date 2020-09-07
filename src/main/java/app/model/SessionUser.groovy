package app.model

import app.dao.model.user.User

class SessionUser {

    String sessionId
    User user
    SessionMsgType msgType
    String msg

}

enum SessionMsgType {
    ACTION, WARN, ERROR
}