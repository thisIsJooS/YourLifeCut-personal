package youtlifecut.app.dto;

import lombok.Data;
import youtlifecut.app.domain.Place;

import java.util.List;

@Data
public class CurationDto {
    private Long curationId;
    private String subtitle;
    private List<Place> places;
}
