package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youtlifecut.app.domain.Review_Like;

@Repository
public interface ReviewLikeRepository extends JpaRepository<Review_Like, Long> {
}
