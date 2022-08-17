package youtlifecut.app.dto.review;

import lombok.Builder;
import lombok.Data;

@Data
public class ReviewKeywordDto {
    private String name;

    @Builder
    public ReviewKeywordDto(String name){
        this.name = name;
    }
}
