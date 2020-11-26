package ro.h23.uac.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ro.h23.uac.access.TrivialAuthenticationManager;

// https://docs.spring.io/spring-security/site/docs/5.2.x/reference/html/overall-architecture.html
@Component
public class AuthenticationExample {
	//private static final Logger log = LoggerFactory.getLogger(AuthenticationExample.class);

	@Autowired
	private TrivialAuthenticationManager authenticationManager;

	public void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Please enter your username: ");
			String name = in.readLine();
			System.out.println("Please enter your password: ");
			String password = in.readLine();
			try {
				Authentication request = new UsernamePasswordAuthenticationToken(name, password);
				Authentication result = authenticationManager.authenticate(request);
				// Spring Security doesn’t mind how you put the Authentication object inside the SecurityContextHolder.
				// The only critical requirement is that the SecurityContextHolder contains an Authentication
				SecurityContextHolder.getContext().setAuthentication(result);
				break;
			} catch (AuthenticationException e) {
				System.out.println("Authentication failed: " + e.getMessage());
			}
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Successfully authenticated. Security context contains: " + auth);
		if (auth.getAuthorities().contains(new SimpleGrantedAuthority(new String("ROLE_USER")))) {
			System.out.println("Rol USER");
		}
	}
}
