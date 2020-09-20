package app.dao.model.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User implements Serializable{

    @Id
    @GeneratedValue
    Long id;
    String userName
    String password

    Role role

}
