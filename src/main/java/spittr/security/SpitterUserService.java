package spittr.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spittr.Spitter;
import spittr.data.SpitterRepository;

public class SpitterUserService implements UserDetailsService {
	private final SpitterRepository spitterRepository;
	
	public SpitterUserService(SpitterRepository spitterRepository) {
		// TODO Auto-generated constructor stub
		this.spitterRepository = spitterRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Spitter spitter = spitterRepository.findByUsername(username);
		if(spitter!=null) {
			List<GrantedAuthority> authoroties = new ArrayList<GrantedAuthority>();
			authoroties.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User(spitter.getUsername(),spitter.getPassword(),authoroties);
		}
		throw new UsernameNotFoundException("User "+username+" not found.");
	}

}
