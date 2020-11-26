package ro.h23.uac.access;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class TrivialAuthenticationManager implements AuthenticationManager {
	
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

	static {
		// Examples of GrantedAuthority - ROLE_USER, READ_AUTHORITY, WRITE_PRIVILEGE, CAN_EXECUTE_AS_ROOT
		// protected by authority vs protected by role
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	/**
	 * Will authenticate if the username and password are the same.
	 * If assigns the role ROLE_USER to each user.
	 */
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		if (auth.getName().equals(auth.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
		}
		throw new BadCredentialsException("Bad Credentials");
	}
}