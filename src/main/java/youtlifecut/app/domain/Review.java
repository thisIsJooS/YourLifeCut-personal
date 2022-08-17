package youtlifecut.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Data
@DynamicInsert
public class Review extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private String image;
    private String content;
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ColumnDefault("0")
    private Integer likeCnt;

    @OneToMany(mappedBy = "review")
    private List<Review_Like> reviewLikes = new ArrayList<>();


    @ManyToMany(mappedBy = "reviews")
    private List<Keyword> keywords = new ArrayList<>();

    //==생성메소드==//
    public void postReview(Place place){
        this.place = place;
        place.getReviews().add(this);
    }

    public void updateKeywordAndAddReviewInKeyword(List<Keyword> keywords){
        this.keywords = keywords;
        for (Keyword keyword : keywords){
            keyword.getReviews().add(this);
        }
    }

}
