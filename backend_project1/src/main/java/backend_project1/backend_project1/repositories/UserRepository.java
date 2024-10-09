package backend_project1.backend_project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backend_project1.backend_project1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
