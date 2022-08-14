package youtlifecut.app.dto.place;

import lombok.Builder;
import lombok.Data;
import youtlifecut.app.domain.Review;

import java.util.List;

@Data
public class PlaceSearchDto {
    private String placename;
    private List<Review> reviews;

    @Builder
    public PlaceSearchDto(String placename, List<Review> reviews){
        this.placename = placename;
        this.reviews = reviews;
    }
}
