package com.security.springsecurity5.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.security.springsecurity5.model.Customer;
import com.security.springsecurity5.repository.CustomerRepository;

@Component
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<Customer> customer = customerRepository.findByEmail(userName);
		if (customer.size() > 0) {
			if (passwordEncoder.matches(password, customer.get(0).getPwd())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(userName, password, authorities);
			} else {
				throw new BadCredentialsException("Invalid password");
			}
		} else {
			throw new BadCredentialsException("No User Register with this Details!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
