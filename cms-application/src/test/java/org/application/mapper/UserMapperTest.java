package org.application.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.api.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper; // 使用 @Autowired 注入

    @Test
    //@Transactional(propagation = Propagation.NOT_SUPPORTED) // 禁用事务回滚
    public void testInsert() {
        User user = User.builder().username("test").password("123456").build();
        int insert = userMapper.insert(user);
        Assertions.assertEquals(1, insert);
    }
}

