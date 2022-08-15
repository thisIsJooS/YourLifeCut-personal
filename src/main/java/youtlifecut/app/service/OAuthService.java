package youtlifecut.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youtlifecut.app.domain.User;
import youtlifecut.app.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class OAuthService {
    private final UserRepository userRepository;

    public Long getUserId(String username){


        System.out.println("dasjidjoiad >>> " + username);

        User user = userRepository.findByName(username)
                .orElseThrow(() -> new IllegalStateException("그런 유저 없음"));;
        return user.getId();
    }
}
