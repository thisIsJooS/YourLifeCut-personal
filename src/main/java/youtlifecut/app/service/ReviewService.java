package youtlifecut.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youtlifecut.app.domain.*;
import youtlifecut.app.dto.place.PlaceSearchDto;
import youtlifecut.app.dto.review.ReviewDeleteDto;
import youtlifecut.app.dto.review.ReviewDetailDto;
import youtlifecut.app.dto.review.ReviewLocationAddDto;
import youtlifecut.app.dto.review.ReviewPostDto;
import youtlifecut.app.repository.PlaceRepository;
import youtlifecut.app.repository.ReviewLikeRepository;
import youtlifecut.app.repository.ReviewRepository;
import youtlifecut.app.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewLikeRepository reviewLikeRepository;
    private final UserRepository userRepository;

    private final PlaceRepository placeRepository;

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
//        review.setKeywords(reviewPostDto.getKeywords());

        ArrayList<String> keywordsStringList = reviewPostDto.getKeywords();

        // 키워드 추가 문제... 뭘까요
        ArrayList<Keyword> keywordsEntityList = new ArrayList<>();
        for(String keyword : keywordsStringList){
            keywordsEntityList.add(new Keyword(keyword));
        }
        review.setKeywords(keywordsEntityList);
        // 키워드 추가 문제

        reviewRepository.save(review);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 리뷰 삭제
     */
    public ResponseEntity deleteReview(ReviewDeleteDto reviewDeleteDto){
        reviewRepository.deleteById(reviewDeleteDto.getReviewId());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * placename으로 리뷰 검색
     */
    public PlaceSearchDto getReviewByPlaceName(String placeName){
        Place place = placeRepository.findByName(placeName)
                .orElse(null);

        if(place == null){
            return PlaceSearchDto.builder().placename(null).build();
        }

        PlaceSearchDto placeSearchDto = PlaceSearchDto.builder()
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