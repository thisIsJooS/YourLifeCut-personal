package youtlifecut.app.dto.place;

import lombok.Builder;
import lombok.Data;
import youtlifecut.app.domain.Review;

import java.util.List;

@Data
public class PlaceSearchDto {
    private String placename;

    @Builder
    public PlaceSearchDto(String placename){
        this.placename = placename;
    }
}
