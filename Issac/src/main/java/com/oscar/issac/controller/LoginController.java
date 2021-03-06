package com.oscar.issac.controller;

import com.oscar.issac.domain.SysUser;
import com.oscar.issac.model.UserForm;
import com.oscar.issac.service.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    private SysUserServiceImpl sysUserService;

    @Autowired
    public void autoWired(SysUserServiceImpl sysUserService) {
        this.sysUserService = sysUserService;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password, HttpSession session) {
        SysUser sysUser = sysUserService.findByUsernameAndPassword(username, password);
        if (sysUser != null) {
            session.setAttribute("user", sysUser);
            return "index";
        }
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult bindResults, Model model) {
        if (!userForm.confirmPassword()) {
            bindResults.rejectValue("confirmPassword", "confirmError", "密碼不一致");
        }

        if (bindResults.hasErrors()) {
            return "register";
        }

        SysUser sysUser = userForm.convertToSysUser();
        sysUserService.saveUser(sysUser);
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("sdd "+session.getAttribute("user"));
        return "index";
    }
}
