package youtlifecut.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youtlifecut.app.domain.*;
import youtlifecut.app.dto.place.PlaceSearchDto;
import youtlifecut.app.dto.review.ReviewDeleteDto;
import youtlifecut.app.dto.review.ReviewDetailDto;
import youtlifecut.app.dto.review.ReviewLocationAddDto;
import youtlifecut.app.dto.review.ReviewPostDto;
import youtlifecut.app.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewLikeRepository reviewLikeRepository;
    private final UserRepository userRepository;

    private final PlaceRepository placeRepository;

    private final KeywordRepository keywordRepository;

    /**
     * 리뷰 좋아요
     * @param user_id
     * @param review_id
     * @return ok
     */
    public ResponseEntity reviewLike(Long user_id, Long review_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalStateException("그런 유저 없음"));
        Review review = reviewRepository.findById(review_id)
                .orElseThrow(() -> new IllegalStateException("그런 리뷰 없음"));
        Review_Like reviewLike = new Review_Like();

        reviewLike.setReviewLike(review, user);
        reviewLikeRepository.save(reviewLike);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 리뷰 디테일
     */
    public ReviewDetailDto getReviewDetail(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalStateException("그런 리뷰 없음"));
        ReviewDetailDto reviewDetailDto = ReviewDetailDto.builder()
                .userId(review.getUser().getId())
                .placeId(review.getPlace().getId())
                .address(review.getPlace().getAddress())
                .userName(review.getUser().getName())
                .content(review.getContent())
                .build();

        return reviewDetailDto;
    }

    /**
     * 리뷰 저장
     */
    public ResponseEntity postReview(ReviewPostDto reviewPostDto){
        Place place = placeRepository.findById(reviewPostDto.getPlaceId())
                .orElseThrow(() -> new IllegalStateException("그런 장소 없음"));

        User user = userRepository.findById(reviewPostDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("그런 유저 없음"));

        Review review = new Review();
        review.setUser(user);
        review.setImage(reviewPostDto.getImage());
        review.setContent(reviewPostDto.getContent());
        review.setRate(reviewPostDto.getRate());
        review.setPlace(place);

        // review id를 일단 생성
        reviewRepository.save(review);

        // 키워드 설정
        System.out.println("이거 되나요?>>>> " + reviewPostDto.getKeywords());

        List<Keyword> keywordList = new ArrayList<Keyword>();
        for(String keywordString : reviewPostDto.getKeywords()){
            System.out.println("이거야 >> " + keywordString);

            Keyword keyword;
            if (keywordRepository.findByName(keywordString).equals(Optional.empty())){
                keyword = new Keyword();
                keyword.setName(keywordString);
                keywordRepository.save(keyword);
            }else{
                keyword = keywordRepository.findByName(keywordString)
                        .orElseThrow(() -> new IllegalStateException("그런 키워드 없음"));
            }

            keywordList.add(keyword);
        }
        // 키워드 설정 끝

        review.updateKeywordAndAddReviewInKeyword(keywordList);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 리뷰 삭제
     */
    public Long deleteReview(ReviewDeleteDto reviewDeleteDto){
        reviewRepository.deleteById(reviewDeleteDto.getReviewId());
        return reviewDeleteDto.getReviewId();
    }

    /**
     * placename으로 해당 장소가 등록되어있는지 검색
     */
    public PlaceSearchDto getReviewByPlaceName(String placeName){
        Place place = placeRepository.findByName(placeName)
                .orElse(null);

        if(place == null){
            return PlaceSearchDto.builder().placename(null).build();
        }

        PlaceSearchDto placeSearchDto = PlaceSearchDto.builder()
                .placeId(place.getId())
                .placename(place.getName())
                .build();

        return placeSearchDto;
    }

    public ResponseEntity addPlace(ReviewLocationAddDto reviewLocationAddDto){

        Place place = new Place();
        place.setName(reviewLocationAddDto.getPlaceName());

        placeRepository.save(place);
        return new ResponseEntity(HttpStatus.OK);
    }



}