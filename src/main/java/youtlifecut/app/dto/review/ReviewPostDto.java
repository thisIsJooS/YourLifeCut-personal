package youtlifecut.app.dto.review;

import lombok.Builder;
import lombok.Data;
import youtlifecut.app.domain.Keyword;

import java.util.List;

@Data
public class ReviewPostDto {
    private Long userId;
    private Long placeId;
    private List<Keyword> keywords;
    private String content;
    private Integer rate;
    private String image;

    @Builder
    public ReviewPostDto(Long userId, Long placeId, List<Keyword> keywords, String content, Integer rate, String image){
        this.userId = userId;
        this.placeId = placeId;
        this.keywords = keywords;
        this.content = content;
        this.rate = rate;
        this.image = image;
    }

}
