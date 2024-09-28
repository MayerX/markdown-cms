package org.application.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.api.dto.UserDTO;
import org.api.entity.User;
import org.application.service.IUserService;
import org.common.entity.ResultEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-09-16 21:23
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/page")
    public ResultEntity<IPage<User>> page(Page<User> page, UserDTO dto) {
        IPage<User> ressult = userService.selectUserPage(page, dto);
        return ResultEntity.success(ressult);
    }

    @PostMapping("/register")
    public ResultEntity<String> register(@RequestBody UserDTO userDTO) {
        return ResultEntity.success(userService.register(userDTO));
    }

}
