package org.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.api.dto.UserDTO;
import org.api.entity.User;

public interface IUserService extends IService<User> {

    /**
     *
     * @param page
     * @param dto
     * @return
     */
    IPage<User> selectUserPage(Page<User> page, UserDTO dto);
}
