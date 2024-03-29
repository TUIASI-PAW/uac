package ro.h23.uac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>> " + port);
        String content = this.restTemplate.getForObject("http://localhost:" + port + "/hello",
                String.class);
        System.out.println(">>>>>>>>>>>>>>>>>> " + content);
        assertThat(content).contains("Hello, World");
    }

}

