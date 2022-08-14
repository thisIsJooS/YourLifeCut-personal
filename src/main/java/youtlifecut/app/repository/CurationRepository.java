package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youtlifecut.app.domain.Curation;

public interface CurationRepository extends JpaRepository<Curation, Long> {
}
