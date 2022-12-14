package ro.h23.uac;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.h23.uac.api.UserController;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

    // @DirtiesContext - Test annotation which indicates that the ApplicationContext associated with a test is dirty and should therefore be closed and removed from the context cache.

    @Test
    public void contextLoads() throws Exception {
        // check if the userController object is created
        assertThat(userController).isNotNull();
    }
}
