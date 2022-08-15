package youtlifecut.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import youtlifecut.app.domain.Curation;
import youtlifecut.app.domain.Place;
import youtlifecut.app.domain.Review;
import youtlifecut.app.repository.*;
import youtlifecut.app.service.HomeService;
import youtlifecut.app.service.ReviewService;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class DataAddTest {
    @Autowired
    EntityManager em;
    @Autowired
    HomeService homeService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    CurationRepository curationRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    ReviewLikeRepository reviewLikeRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 장소추가() throws Exception{
        Place place = new Place();
        place.setAddress("상도동");
        place.setCategory("카테고리1");
        place.setName("숭실대");
        place.setPhone_num("02-333-2222");
        place.setRating(4.0F);
        place.setCuration(new Curation(1L, "큐레이션1"));

        placeRepository.save(place);
    }
}
