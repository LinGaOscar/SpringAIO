package com.oscar.issac.service;

import com.oscar.issac.domain.SysUser;
import com.oscar.issac.domain.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    private SysUserRepository sysUserRepository;

    @Autowired
    public void autoWired(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public SysUser saveUser(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public SysUser updateUser(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser findByUsernameAndPassword(String username, String password) {
        return sysUserRepository.findByUsernameAndPassword(username,password);
    }
}
