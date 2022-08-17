package youtlifecut.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String nickname;

    @Builder
    public UserDto(Long userId, String nickname){
        this.userId = userId;
        this.nickname = nickname;
    }

}
