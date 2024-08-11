import lombok.AllArgsConstructor;
import org.api.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.service.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-08-11 00:45
 */
@SpringBootTest
@AllArgsConstructor
public class UserMapperTest {

    private final UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = User.builder().username("test").password("123456").build();
        int insert = userMapper.insert(user);
        Assertions.assertEquals(1, insert);
    }

}
