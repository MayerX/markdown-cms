package org.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.api.dto.UserDTO;
import org.api.entity.User;
import org.application.mapper.UserMapper;
import org.application.service.IUserService;
import org.common.utils.MessageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import java.sql.Wrapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public IPage<User> selectUserPage(Page<User> page, UserDTO dto) {
        IPage<User> userPage =  baseMapper.selectUserPage(dto, page);
        return userPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(UserDTO userDTO) {
        if (usernameExists(userDTO.getUsername())) {
            throw new RuntimeException(MessageUtils.getMessage("user.username.exists"));
        }
        if (emailExists(userDTO.getEmail())) {
            throw new RuntimeException(MessageUtils.getMessage("user.email.exists"));
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        baseMapper.insert(user);

        return "";
    }

    private User findByUsername(String username) {
        return baseMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username));
    }

    // 私有方法，检查用户名是否存在
    private boolean usernameExists(String username) {
        return baseMapper.selectCount(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username)) > 0;
    }

    // 私有方法，检查邮箱是否存在
    private boolean emailExists(String email) {
        return baseMapper.selectCount(Wrappers.lambdaQuery(User.class).eq(User::getEmail, email)) > 0;
    }


}
