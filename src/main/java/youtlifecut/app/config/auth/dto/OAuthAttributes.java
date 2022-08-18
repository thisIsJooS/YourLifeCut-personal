package youtlifecut.app.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import youtlifecut.app.domain.Provider;
import youtlifecut.app.domain.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private String snsId;
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String picture;

    private String email;


    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,String snsId, String name,  String picture, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.snsId = snsId;
        this.name = name;
        this.picture = picture;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .snsId((String) attributes.get("sub"))
                .name((String) attributes.get("name"))
                .picture((String) attributes.get("picture"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public User toEntity() {
        return User.builder()
                .snsId(snsId)
                .name(name)
                .profile_image(picture)
                .email(email)
                .provider(Provider.GOOGLE)
                .build();
    }
}