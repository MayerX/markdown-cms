package org.application.controller;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.common.utils.MessageUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-10-02 00:02
 */
@SpringBootTest
public class I18ControllerTest extends AcceptHeaderLocaleResolver {

    @Test
    public void demo() {
        String message = MessageUtils.getMessage("user.username.exists");
        Assertions.assertEquals("用户名已存在1", message);
    }

}
