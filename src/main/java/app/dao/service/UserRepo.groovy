package app.dao.service;

import app.dao.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository;

@Repository
interface UserRepo extends JpaRepository<User, Long> {}