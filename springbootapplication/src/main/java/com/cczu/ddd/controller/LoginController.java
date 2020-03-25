package com.cczu.ddd.controller;

import com.cczu.ddd.util.IVerifyCodeGen;
import com.cczu.ddd.util.SimpleCharVerifyCodeGenImpl;
import com.cczu.ddd.util.VerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author ddd
 * @create 2020-03-19    17:36
 **/
@Controller
public class LoginController {
    Logger log= LoggerFactory.getLogger(getClass());

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("code")String code,
                        Map<String ,Object> map,
                        HttpSession session) {
        System.out.println("username = " + username);
        if (username.equals(password)) {
            session.setAttribute("username",username);
            return "redirect:/loginforuser";
        }
        else{
            map.put("message","用户名密码错误");
            return "redirect:/index";
        }
    }
    @RequestMapping("/loginforuser")
    public String loginforuser() {

        return "indexlogin";
    }
    // 验证码
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }


    }
}
