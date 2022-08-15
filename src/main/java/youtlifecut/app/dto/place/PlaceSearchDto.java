package youtlifecut.app.dto.place;

import lombok.Builder;
import lombok.Data;
import youtlifecut.app.domain.Review;

import java.util.List;

@Data
public class PlaceSearchDto {

    private Long placeId;
    private String placename;

    @Builder
    public PlaceSearchDto(Long placeId, String placename){
        this.placeId = placeId;
        this.placename = placename;

    }
}
