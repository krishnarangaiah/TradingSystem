package app.dao.service

import app.dao.model.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private UserRepo userRepo

    void save(User user) {
        userRepo.save(user)
    }

    User findById(Long id) {
        return userRepo.findById(id).orElse(null)
    }

    void delete(User user) {
        userRepo.delete(user)
    }

    List<User> findAll() {
        return userRepo.findAll()
    }

    List<User> authenticate(String userName) {
        return userRepo.findByUserName(userName)
    }

}
