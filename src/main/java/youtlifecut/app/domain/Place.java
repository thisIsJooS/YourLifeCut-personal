package youtlifecut.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Data
public class Place{
    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private Long id;
    private String name;
    private String address;
    private String category;
    private String phone_num;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curation_id")
    private Curation curation;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "place" , fetch = FetchType.LAZY)
    private List<Place_Like> placeLikes = new ArrayList<>();


    @ManyToMany(mappedBy = "places")
    private List<Keyword> keywords = new ArrayList<>();

    //==생성메소드==//
    public void setPlaceImage(Image image){
        this.images.add(image);
        image.setPlace(this);
    }

    public void setCuration(Curation curation){
        this.curation = curation;
        curation.getPlaces().add(this);
    }



}
