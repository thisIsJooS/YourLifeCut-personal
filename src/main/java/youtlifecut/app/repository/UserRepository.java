package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youtlifecut.app.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String nickname);
    Optional<User> findByEmail(String email);

    Optional<User> findBySnsId(String snsId);
}
