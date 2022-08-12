package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youtlifecut.app.domain.Place;
import youtlifecut.app.domain.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<List<Review>> findByPlaceOrderByLikeCntDesc(Place place);

    Optional<List<Review>> findByPlace(Place place);
}


