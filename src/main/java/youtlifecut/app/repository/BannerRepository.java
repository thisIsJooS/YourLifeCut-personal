package youtlifecut.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youtlifecut.app.domain.Banner;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

}
