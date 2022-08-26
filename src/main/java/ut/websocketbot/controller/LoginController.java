package ut.websocketbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private ChatService chatService;
    @Autowired
    private MessageFactory messageFactory;

    @GetMapping
    public ModelAndView doGet(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            mav.setViewName(AppConstants.LOGIN_FORM);
        } else {
            mav.setViewName(AppConstants.CHAT_FORM);
        }
        return mav;
    }

    @PostMapping
    public ModelAndView doPost(@ModelAttribute UserDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        User user;
        String userName = dto.getName();

        if (userName == null || userName.length() == 0) {
            mav.setViewName(AppConstants.LOGIN_FORM);
        } else {
            user = loginService.getUserByName(userName);
            if (user == null) {
                user = loginService.addUser(userFactory.createVO(dto));
            }
            mav = chatService.getModelAndViewMessageHistory(mav);
            mav.addObject("userId", user.getId());
            session.setAttribute("user", user);
        }
        return mav;
    }
}
