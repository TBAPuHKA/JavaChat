package ut.websocketbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.websocketbot.entity.UserDTO;
import ut.websocketbot.factory.UserFactory;
import ut.websocketbot.model.User;

@Slf4j
@Service
public class LoginService {

    @Autowired
    UserService userService;
    @Autowired
    UserFactory userFactory;

    public User addUser(UserDTO userDTO) {
        User user = userFactory.createVO(userDTO);
        return addUser(user);
    }

    public User addUser(User user) {
        return userService.addUser(user);
    }

    public User getUserByName(String name) {
        return userService.getUserByName(name);
    }

}
