package ut.websocketbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ut.websocketbot.AppConstants;
import ut.websocketbot.entity.MessageDTO;
import ut.websocketbot.factory.MessageFactory;
import ut.websocketbot.model.Message;
import ut.websocketbot.service.ChatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ErrorsController implements ErrorController {

    @Autowired
    ChatService chatService;

    @RequestMapping("/error")
    public ModelAndView error(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            mav.setViewName(AppConstants.LOGIN_FORM);
        } else {
            mav = chatService.getModelAndViewMessageHistory(mav);
        }
        return mav;
    }
}
