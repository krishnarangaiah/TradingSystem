package app.dao.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User {

    @Id
    @GeneratedValue
    Long id;
    String userName
    String password

}
