package com.oscar.issac.model;

import com.oscar.issac.domain.SysUser;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserForm {

    public static final String PHONE_REG = "^09\\d{8}$";

    @NotBlank
    private String username;
    @NotBlank
    @Length(min = 6, message = "長度最小為6位")
    private String password;
    @NotBlank
    private String confirmPassword;
    @Pattern(regexp = PHONE_REG, message = "請輸入正確手機號碼")
    private String phone;
    @Email
    private String email;

    public boolean confirmPassword() {
        return this.password.equals(this.confirmPassword);
    }

    public SysUser convertToSysUser() {
        return new UserFormConvert().convert(this);
    }

    private static class UserFormConvert implements FormConvert<UserForm, SysUser> {
        @Override
        public SysUser convert(UserForm userForm) {
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(userForm, sysUser);
            return sysUser;
        }
    }
}
