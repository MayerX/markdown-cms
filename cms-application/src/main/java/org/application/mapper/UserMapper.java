package org.application.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.api.dto.UserDTO;
import org.api.entity.User;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    IPage<User> selectUserPage(UserDTO dto, IPage<User> page);
}
