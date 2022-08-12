package youtlifecut.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class Review_Like {
    @Id
    @GeneratedValue
    @Column(name = "review_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //==생성메소드==//
    public void setReviewLike(Review review, User user){
        this.review = review;
        this.user = user;
        review.getReviewLikes().add(this);
        user.getReview_likes().add(this);
        review.setLikeCnt(review.getLikeCnt() + 1);
    }
}
