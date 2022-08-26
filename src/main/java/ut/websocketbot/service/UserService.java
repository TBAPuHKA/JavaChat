package ut.websocketbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.websocketbot.model.User;
import ut.websocketbot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User addUser(User user) {
        return userRepository.insert(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
       return userRepository.findByName(name);
    }
}
