package youtlifecut.app.config.auth.dto;

import lombok.Getter;
import youtlifecut.app.domain.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.picture = user.getPicture();
    }
}