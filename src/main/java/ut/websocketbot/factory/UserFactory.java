package ut.websocketbot.factory;

import org.springframework.stereotype.Service;
import ut.websocketbot.entity.UserDTO;
import ut.websocketbot.model.User;

@Service
public class UserFactory implements EntityFactory <User, UserDTO> {

    @Override
    public User createVO(UserDTO dto) {
        User vo = new User();
        vo.setId(dto.getId());
        vo.setName(dto.getName());
        return vo;
    }

    @Override
    public UserDTO createDTO(User vo) {
        UserDTO dto = new UserDTO();
        dto.setId(vo.getId());
        dto.setName(vo.getName());
        return dto;
    }
}
