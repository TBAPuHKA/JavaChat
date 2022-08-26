package ut.websocketbot.factory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.websocketbot.entity.MessageDTO;
import ut.websocketbot.model.Message;
import ut.websocketbot.service.UserService;

@Service
public class MessageFactory implements EntityFactory <Message, MessageDTO> {

    @Autowired
    UserService userService;

    @Override
    public Message createVO(MessageDTO dto) {
        Message vo = new Message();
        vo.setId(dto.getId());
        vo.setContent(dto.getContent());
        vo.setUserId(dto.getUserId());
        return vo;
    }

    @Override
    public MessageDTO createDTO(Message vo) {
        MessageDTO dto = new MessageDTO();
        dto.setId(vo.getId());
        dto.setContent(vo.getContent());
        dto.setUserId(vo.getUserId());
        dto.setUserName(userService.getUserById(vo.getUserId()).get().getName());

        return dto;
    }
}
