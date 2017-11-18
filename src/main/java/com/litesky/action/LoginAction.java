package com.litesky.action;

import com.litesky.model.User;
import com.litesky.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by finefine.com on 2017/11/15.
 */
@Action(value = "login")
@Results(value = {@Result(name = "success",location = "/success.jsp"),@Result(name = "fail",location = "/fail.jsp")})
@Component
public class LoginAction extends ActionSupport {

    @Resource
    private UserService userService;

    private String username;

    private String password;

    public void setUsername(String username) {
        System.out.println("username 注入");
        this.username = username;
    }

    public void setPassword(String password) {
        System.out.println("password 注入");
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("执行execute()");
        User user= userService.findUserByNameAndPwd(this.username, this.password);
        if (user != null) {
            return "success";
        }
        return "fail";
    }
}
