package ro.h23.uac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;
import ro.h23.uac.model.User;
import ro.h23.uac.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testRepository()
    {
        User user = new User();
        user.setUsername("ana");
        user.setEmail("ana@abc.com");
        user.setPassword("mypass");

        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }
}