package app.dao.model.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


interface RoleActionMapping {
    List<Action> ADMIN_ACTIONS = Arrays.asList(Action.ALL);
}

public enum Role {

    ADMIN(RoleActionMapping.ADMIN_ACTIONS),
    OWNER(null),
    QA(null),
    BA(null),
    DEVELOPER(null);

    private List<Action> actions;

    Role(List<Action> actions) {
        this.actions = actions;
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(this.actions);
    }

}

enum Action {
    // All Modules
    ALL,
    // Module #1 User
    USER_C, USER_R, USER_U, USER_D

}