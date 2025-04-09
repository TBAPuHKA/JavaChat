package ut.websocketbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ut.websocketbot.entity.UserDTO;
import ut.websocketbot.factory.UserFactory;
import ut.websocketbot.model.User;
import ut.websocketbot.service.ChatService;
import ut.websocketbot.service.LoginService;
import ut.websocketbot.util.AppConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestConroller {

    @GetMapping(params = "actionName")
    public ModelAndView testing(@RequestParam("actionName")String actionName, HttpServletRequest req) {
        if (actionName.equals("testng1")) {
            //куда-то отправляем что-то делать
        } else   if (actionName.equals("testng2")) {
            //куда-то отправляем что-то делать
        }
        return null;
    }
}