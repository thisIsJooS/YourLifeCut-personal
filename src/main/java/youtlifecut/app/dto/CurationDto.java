package youtlifecut.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import youtlifecut.app.domain.Curation;
import youtlifecut.app.domain.Place;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CurationDto {
    private Long curationId;
    private String subtitle;
    private List<Place> places;

    public CurationDto(Curation curation){
        this.curationId = curation.getId();
        this.subtitle = curation.getSubtitle();
        this.places = Place.placeList(curation.getPlaces());
    }
    // ProductImage == Place, Product == Curation, imageList == placeList
    @Getter
    static class Place{
        private Long id;
        private String image;
        private String category;
        private Float rating;
        private String name;

        static List<Place> placeList(List<youtlifecut.app.domain.Place> places){
            List<Place> curationPlaceList = new ArrayList<>();
            places.forEach(place -> curationPlaceList.add(new Place(place)));
            return curationPlaceList;
        }

        public Place(youtlifecut.app.domain.Place place){
            this.id = place.getId();
            if(place.getImages().size() == 0){
                this.image = "";
            }else{
                this.image = place.getImages().get(0).getImage_url();
            }
            this.category = place.getCategory();
            this.rating = place.getRating();
            this.name = place.getName();
        }
    }
}
