package com.oscar.issac.service;

import com.oscar.issac.domain.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser saveUser(SysUser sysUser);
    SysUser updateUser(SysUser sysUser);
    List<SysUser> findAll();
}
