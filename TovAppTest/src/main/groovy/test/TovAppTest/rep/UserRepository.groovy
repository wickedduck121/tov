package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import test.TovAppTest.entities.User

interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    User findByName(String name);
}