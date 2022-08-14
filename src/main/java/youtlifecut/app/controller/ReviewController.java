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

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("")
    public ReviewDetailDto getReviewDetail(@RequestParam(name = "reviewId") Long id){
        return reviewService.getReviewDetail(id);
    }

    @PostMapping("")
    public ResponseEntity postReview(@RequestBody ReviewPostDto reviewPostDto){
        return reviewService.postReview(reviewPostDto);
    }


    @DeleteMapping("")
    public ResponseEntity deleteReview(@RequestBody ReviewDeleteDto reviewDeleteDto){
        return reviewService.deleteReview(reviewDeleteDto);
    }

    @GetMapping("/search")
    public PlaceSearchDto getReviewByPlaceName(@RequestParam(name="placename") String placeName){
        return reviewService.getReviewByPlaceName(placeName);
    }

    @PostMapping("/location")
    public ResponseEntity addPlace(@RequestBody ReviewLocationAddDto reviewLocationAddDto){
        return reviewService.addPlace(reviewLocationAddDto);
    }

    @GetMapping("/like")
    public ResponseEntity reviewLike(@RequestParam(name = "userId") Long user_id, @RequestParam(name = "reviewId") Long review_id){
        return reviewService.reviewLike(user_id, review_id);
    }


}
