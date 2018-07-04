package test;

import com.ssmv.common.entity.User;
import com.ssmv.common.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    public void userinset(){
        User user = new User();
        user.setUuid("1");
        user.setName("1");
        user.setPassword("1");
        userService.add(user);
    }
}
