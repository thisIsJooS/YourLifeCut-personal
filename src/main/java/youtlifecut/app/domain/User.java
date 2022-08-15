package youtlifecut.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String picture;

    @ColumnDefault("0")
    private Integer mileage;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Place_Like> place_likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review_Like> review_likes = new ArrayList<>();


    @ManyToMany(mappedBy = "users")
    private List<Keyword> keywords = new ArrayList<>();


    @Builder
    public User(Long id, String name, String picture, String email, Role role){
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }


    public String getRoleKey(){
        return this.role.getKey();
    }
}
