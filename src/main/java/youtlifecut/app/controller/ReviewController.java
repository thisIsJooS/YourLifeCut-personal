package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youtlifecut.app.domain.Review;
import youtlifecut.app.dto.ReviewDeleteDto;
import youtlifecut.app.dto.ReviewDetailDto;
import youtlifecut.app.dto.ReviewPostDto;
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

    @GetMapping("/like")
    public ResponseEntity reviewLike(@RequestParam(name = "userId") Long user_id, @RequestParam(name = "reviewId") Long review_id){
        return reviewService.reviewLike(user_id, review_id);
    }

    @DeleteMapping("")
    public ResponseEntity deleteReview(@RequestBody ReviewDeleteDto reviewDeleteDto){
        return reviewService.deleteReview(reviewDeleteDto);
    }


}
