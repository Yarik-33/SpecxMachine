package by.kuchinskiy.speczmachine.service;

import by.kuchinskiy.speczmachine.entity.User;
import by.kuchinskiy.speczmachine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}