package ut.websocketbot.controller;

import com.sun.tracing.dtrace.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ut.websocketbot.AppConstants;
import ut.websocketbot.entity.MessageDTO;
import ut.websocketbot.entity.UserDTO;
import ut.websocketbot.factory.MessageFactory;
import ut.websocketbot.factory.UserFactory;
import ut.websocketbot.model.Message;
import ut.websocketbot.model.User;
import ut.websocketbot.service.ChatService;
import ut.websocketbot.service.LoginService;
import ut.websocketbot.service.MessageService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController extends HttpServlet {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public ModelAndView doGet(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            mav.setViewName(AppConstants.LOGIN_FORM);
        } else {
            mav = chatService.getModelAndViewMessageHistory(mav);
        }
        return mav;
    }

    @PostMapping
    public ModelAndView doPost(@ModelAttribute MessageDTO dto, String logOut, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();

        String sendMessage = dto.getContent();

        if (session.getAttribute("user") == null || logOut != null) {
            session.setAttribute("user", null);
            mav.setViewName(AppConstants.LOGIN_FORM);
        } else {
            if(sendMessage!=null){
                User user = (User) session.getAttribute("user");
                dto.setUserId(user.getId());
                chatService.addMessage(dto);
            }
            mav = chatService.getModelAndViewMessageHistory(mav);
        }

        return mav;
    }
}
