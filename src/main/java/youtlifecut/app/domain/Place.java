package youtlifecut.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
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

}
