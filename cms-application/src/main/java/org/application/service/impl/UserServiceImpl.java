package org.application.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.api.dto.UserDTO;
import org.api.entity.User;
import org.application.mapper.UserMapper;
import org.application.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public IPage<User> selectUserPage(Page<User> page, UserDTO dto) {
        IPage<User> userPage =  baseMapper.selectUserPage(dto, page);
        return userPage;
    }
}
