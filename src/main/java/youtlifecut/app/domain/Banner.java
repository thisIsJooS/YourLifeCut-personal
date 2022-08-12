package youtlifecut.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Banner {
    @Id
    @GeneratedValue
    @Column(name = "banner_id")
    private Long id;

    private String images;
}
