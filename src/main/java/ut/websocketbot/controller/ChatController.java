package ut.websocketbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ut.websocketbot.entity.Greeting;
import ut.websocketbot.entity.HelloMessage;
import ut.websocketbot.entity.MessageDTO;
import ut.websocketbot.service.ChatService;

import javax.servlet.http.HttpServlet;

@Slf4j
@Controller
//@RestController
//@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

//    @MessageMapping("/intest")
////    @SendTo("/topic/greetings")
//    public Greeting processMessage(HelloMessage message) throws Exception {
//        log.info("ChatController | processMessage() | IN");
//        Thread.sleep(3000); // simulated delay
//        return new Greeting("Hello, " + message.getName() + "!");
//    }

//    @MessageMapping("/intest")
//    @SendTo("/topic/greetings")
//    public void processMessage(@Payload MessageDTO messageDTO) {
//        chatService.addMessage(messageDTO);
//        ChatMessage saved = chatMessageService.save(chatMessage);
//
//        messagingTemplate.convertAndSendToUser(
//                chatMessage.getRecipientId(),"/queue/messages",
//                new ChatNotification(
//                        saved.getId(),
//                        saved.getSenderId(),
//                        saved.getSenderName()));
//    }


//    @GetMapping
//    public ModelAndView doGet(HttpServletRequest req) {
//        ModelAndView mav = new ModelAndView();
//        HttpSession session = req.getSession();
//
//        if (session.getAttribute("user") == null) {
//            mav.setViewName(AppConstants.LOGIN_FORM);
//        } else {
//            mav = chatService.getModelAndViewMessageHistory(mav);
//        }
//        return mav;
//    }
//
//    @PostMapping
//    public ModelAndView doPost(@ModelAttribute MessageDTO dto, String logOut, HttpServletRequest req) {
//        ModelAndView mav = new ModelAndView();
//        HttpSession session = req.getSession();
//
//        String sendMessage = dto.getContent();
//
//        if (session.getAttribute("user") == null || logOut != null) {
//            session.setAttribute("user", null);
//            mav.setViewName(AppConstants.LOGIN_FORM);
//        } else {
//            if(sendMessage!=null){
//                User user = (User) session.getAttribute("user");
//                dto.setUserId(user.getId());
//                chatService.addMessage(dto);
//            }
//            mav = chatService.getModelAndViewMessageHistory(mav);
//        }
//
//        return mav;
//    }
}
