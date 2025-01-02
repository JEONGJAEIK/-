package org.mysite.myboard.business;

import lombok.RequiredArgsConstructor;
import org.mysite.myboard.data_access.UserRepositroy;
import org.mysite.myboard.dto.UserDTO;
import org.mysite.myboard.presentation.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepositroy userRepository;
    private final PasswordEncoder encoder;

    public User create(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        this.userRepository.save(user);
        return user;
    }
}
