package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youtlifecut.app.domain.Place;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<List<Place>> findByCategory(String category);

    Optional<Place> findByName(String name);


}