package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youtlifecut.app.domain.Keyword;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Optional<Keyword> findByName(String name);
}
