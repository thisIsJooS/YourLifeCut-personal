package youtlifecut.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DynamicInsert
public class User extends BaseTimeEntity{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String profile_image;

    @ColumnDefault("0")
    private Integer mileage;

    private String email;

    private String snsId;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Place_Like> place_likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review_Like> review_likes = new ArrayList<>();


    @ManyToMany(mappedBy = "users")
    private List<Keyword> keywords = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Builder
    public User(String snsId, String name, String profile_image, String email, Provider provider){
        this.snsId = snsId;
        this.name = name;
        this.profile_image = profile_image;
        this.email = email;
        this.provider = provider;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProfile_image(String profile_image){
        this.profile_image = profile_image;
    }

    public User update(String name, String profile_image){
        this.name = name;
        this.profile_image = profile_image;
        return this;
    }

}
