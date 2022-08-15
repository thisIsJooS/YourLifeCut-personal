package youtlifecut.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;
    private String profile_image;
    private String email;

    @Builder
    public UserDto(Long id, String name, String profile_image, String email){
        this.id = id;
        this.name = name;
        this.profile_image = profile_image;
        this.email = email;
    }

}
