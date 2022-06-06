package com.oscar.issac.controller;

import com.oscar.issac.domain.SysUser;
import com.oscar.issac.service.SysUserService;
import com.oscar.issac.service.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private SysUserServiceImpl sysUserService;

    @Autowired
    public void autoWired(SysUserServiceImpl sysUserService) {
        this.sysUserService = sysUserService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam Integer phone) {
        SysUser user = new SysUser();
        user.setUserName(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        sysUserService.saveUser(user);
        return "redirect:/login";
    }
}
