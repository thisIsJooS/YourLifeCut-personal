package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youtlifecut.app.dto.place.PlaceSearchDto;
import youtlifecut.app.dto.review.ReviewDeleteDto;
import youtlifecut.app.dto.review.ReviewDetailDto;
import youtlifecut.app.dto.review.ReviewLocationAddDto;
import youtlifecut.app.dto.review.ReviewPostDto;
import youtlifecut.app.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * 후기 불러오기
     */
    @GetMapping("")
    public ReviewDetailDto getReviewDetail(@RequestParam(name = "reviewId") Long id){
        return reviewService.getReviewDetail(id);
    }

    /**
     * 리뷰 업로드
     */
    @PostMapping("")
    public ResponseEntity postReview(@RequestBody ReviewPostDto reviewPostDto){
        return reviewService.postReview(reviewPostDto);
    }

    /**
     * 리뷰 삭제 요청
     */
    @DeleteMapping("")
    public ResponseEntity deleteReview(@RequestBody ReviewDeleteDto reviewDeleteDto){
        return reviewService.deleteReview(reviewDeleteDto);
    }

    /**
     * 리뷰 작성 시 위치 존재 여부, 없으면 null 리턴
     */
    @GetMapping("/search")
    public PlaceSearchDto getReviewByPlaceName(@RequestParam(name="placename") String placeName){
        return reviewService.getReviewByPlaceName(placeName);
    }


    /**
     * 위치 추가 요청
     */
    @PostMapping("/location")
    public ResponseEntity addPlace(@RequestBody ReviewLocationAddDto reviewLocationAddDto){
        return reviewService.addPlace(reviewLocationAddDto);
    }

    /**
     * 리뷰 좋아요
     */
    @GetMapping("/like")
    public ResponseEntity reviewLike(@RequestParam(name = "userId") Long user_id, @RequestParam(name = "reviewId") Long review_id){
        return reviewService.reviewLike(user_id, review_id);
    }

    /**
     * 리뷰 작성 시 키워드 추가
     */


}
