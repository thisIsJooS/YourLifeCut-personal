package youtlifecut.app.dto.review;

import lombok.Builder;
import lombok.Data;
import youtlifecut.app.domain.Image;

@Data
public class ReviewDetailDto {
    private Long userId;
    private Long placeId;
    private String userName;
    private Long rate;
    private String address;

    private Image image;


    @Builder
    public ReviewDetailDto(Long userId, Long placeId , String userName, Long rate,
                           String address){
        this.userId = userId;
        this.placeId = placeId;
        this.userName = userName;
        this.rate = rate;
        this.address = address;
    }
}