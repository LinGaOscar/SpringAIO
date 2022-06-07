package com.oscar.issac.controller;

import com.oscar.issac.domain.SysUser;
import com.oscar.issac.service.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

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
    public String register(@Valid UserForm userForm, BindingResult bindResults) {
        boolean boo = true;
        if (!userForm.confirmPassword()) {
            bindResults.rejectValue("confirmPassword", "confirmError", "密碼不一致");
            boo = false;
        }

        if (bindResults.hasErrors()) {
            List<FieldError> fieldErrorList = bindResults.getFieldErrors();
            for (FieldError error : fieldErrorList) {
                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
            }
            boo = false;
        }
        if (!boo) {
            return "/register";
        }
        SysUser sysUser = userForm.convertToSysUser();
        sysUserService.saveUser(sysUser);
        return "redirect:/login";
    }
}
