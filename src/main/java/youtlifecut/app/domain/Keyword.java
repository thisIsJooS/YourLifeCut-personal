package youtlifecut.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Keyword {
    @Id
    @GeneratedValue
    @Column(name = "keyword_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "Review_Keyword",
    joinColumns = @JoinColumn(name = "keyword_id"),
    inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "User_Keyword",
            joinColumns = @JoinColumn(name = "keyword_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Place_Keyword",
            joinColumns = @JoinColumn(name = "keyword_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    private List<Place> place = new ArrayList<>();

}
