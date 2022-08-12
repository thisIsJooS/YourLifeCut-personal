package youtlifecut.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Curation {
    @Id
    @GeneratedValue
    @Column(name = "curation_id")
    private Long id;

    private String subtitle;

    @OneToMany(mappedBy = "curation", fetch = FetchType.LAZY)
    private List<Place> places = new ArrayList<>();
}
