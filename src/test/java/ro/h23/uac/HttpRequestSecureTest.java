package ro.h23.uac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// mvn test -Dtest=HttpRequestSecureTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestSecureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "12345")
                .getForEntity("/hellouser", String.class);
        assertThat(HttpStatus.OK).isEqualTo(result.getStatusCode());
    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldFailWith401() throws Exception {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "xxxxxxxxx")
                .getForEntity("/hellouser", String.class);
        assertThat(HttpStatus.UNAUTHORIZED).isEqualTo(result.getStatusCode());
    }
}
