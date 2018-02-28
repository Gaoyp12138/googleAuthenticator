package com.google.authenticator.controller;

import com.google.authenticator.common.GoogleAuthenticator;
import com.google.authenticator.common.RestResp;
import com.google.authenticator.domain.User;
import com.google.authenticator.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @Author: Gaoyp
 * @Description:
 * @Date: Create in 下午1:56 2018/2/28
 * @Modified By:
 */

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/success")
    public String toSuccess(){
        return "success";
    }

    @GetMapping("/authorcation")
    public String toAuth(){
        return "authorcation";
    }

    @PostMapping("/login")
    public @ResponseBody
    RestResp<User> login(@RequestParam String username,
                         @RequestParam String password,
                         HttpServletResponse response,
                         HttpServletRequest request){

        User user = testService.login(username, password);

        if (user != null){
            try {
                HttpSession session = request.getSession();
                session.setAttribute("username",user.getUsername());
                response.sendRedirect("/success");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new RestResp<User>(1,"登录成功",user);
        }else {
            return new RestResp<User>(0,"登录失败",null);
        }

    }


    @PostMapping("/auth")
    public @ResponseBody String auth(HttpServletRequest request,HttpServletResponse response){

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        logger.info(username);
        String secret = GoogleAuthenticator.generateSecretKey();
        String qrcode = GoogleAuthenticator.getQRBarcode(username,secret);
        logger.info(qrcode);
        logger.info(secret);
        session.setAttribute("secret",secret);
        try {
            response.sendRedirect("/authorcation");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return secret + "  " + qrcode;
    }

    @PostMapping("/authorcation")
    public void verifyTest(HttpServletRequest request,
                           Long code) {
        logger.info(code+" ");
        HttpSession session = request.getSession();
        String secret = (String)session.getAttribute("secret");
        long t = System.currentTimeMillis();
        GoogleAuthenticator ga = new GoogleAuthenticator();
        ga.setWindowSize(5);
        boolean r = ga.check_code(secret, code, t);
        logger.info("校验是否通过" + r);
    }

}
