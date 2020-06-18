package com.zaghir.project.todo.directory.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zaghir.project.todo.directory.domain.Person;
import com.zaghir.project.todo.directory.repository.PersonRepository;

public class DirectoryUserDetailsService implements UserDetailsService {

	private PersonRepository repo;

	public DirectoryUserDetailsService(PersonRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			final Person person = this.repo.findByEmailIgnoreCase(username);
			if (person != null) {
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				String password = encoder.encode(person.getPassword());
				return User
						.withUsername(person.getEmail())
						.accountLocked(!person.isEnabled())
						.password(password)
						.roles(person.getRole())
						.build();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		throw new UsernameNotFoundException(username);
	}
}
