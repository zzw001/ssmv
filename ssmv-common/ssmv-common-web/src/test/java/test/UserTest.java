package test;

import com.ssmv.common.entity.User;
import com.ssmv.common.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    public void userInset(){
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName("3");
        user.setPassword("2");
        userService.add(user);
    }

    @Test
    public void nameExistTest(){
        String name = "100000";
        System.out.println(userService.registerExistName(name));
    }

    @Test
    public void loginTest(){
        User user = new User();
        user.setName("1");
        user.setPassword("");
        System.out.println(userService.login(user));
    }
}
