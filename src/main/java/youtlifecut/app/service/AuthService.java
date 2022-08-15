package youtlifecut.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import youtlifecut.app.domain.User;
import youtlifecut.app.dto.UserDto;
import youtlifecut.app.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ResponseEntity setNickname(UserDto userDto){
        User user = userRepository.findById(userDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("그런 유저 없음"));

        user.setName(userDto.getNickname());
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
