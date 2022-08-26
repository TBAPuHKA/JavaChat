package ut.websocketbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.websocketbot.model.Message;
import ut.websocketbot.repository.MessageRepository;

import java.util.List;

@Slf4j
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message addMessage(Message message) {
        return messageRepository.insert(message);
    }

}
