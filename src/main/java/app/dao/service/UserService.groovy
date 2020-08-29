package app.dao.service

import app.dao.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private UserRepo userRepo

    List<User> findAll() {
        return userRepo.findAll()
    }

    void save(User user) {
        userRepo.save(user)
    }

}
