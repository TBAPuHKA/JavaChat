package ut.websocketbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ut.websocketbot.AppConstants;
import ut.websocketbot.entity.MessageDTO;
import ut.websocketbot.factory.MessageFactory;
import ut.websocketbot.model.Message;
import ut.websocketbot.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ChatService {

    @Autowired
    private MessageService messageService;
    @Autowired
    MessageFactory messageFactory;

    public Message addMessage(Message vo) {
        return messageService.addMessage(vo);
    }


    public Message addMessage(MessageDTO dto) {
        return addMessage(messageFactory.createVO(dto));
    }

    public List<Message> getMessageHistory(){
        List<Message>resList = messageService.getMessages();
        Collections.reverse(resList);
        return resList;
    }
//
    public String parseToJSONfromList(List list) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFromList = null;
        try {
            jsonFromList = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            log.error("Parse JSON from list | FAIL");
            e.printStackTrace();
        }
        return jsonFromList;
    }

    public String getJSONMessageHistory() {
        List<Message> voList = getMessageHistory();
        List<MessageDTO> dtoList = new ArrayList<>();
        voList.forEach(e -> {
            dtoList.add(messageFactory.createDTO(e));
        });
        String jsonList = parseToJSONfromList(dtoList);
        return  jsonList;
    }

    public ModelAndView getModelAndViewMessageHistory(ModelAndView mav) {
        String jsonList = getJSONMessageHistory();
        mav.addObject("messageList", jsonList);
        mav.setViewName(AppConstants.CHAT_FORM);
        return mav;
    }
}
