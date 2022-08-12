package youtlifecut.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Place_Like {
    @Id
    @GeneratedValue
    @Column(name = "place_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    //==생성메소드==//
    public void setPlaceLike(Place place, User user){
        this.place = place;
        this.user = user;
        place.getPlaceLikes().add(this);
        user.getPlace_likes().add(this);
    }

}
