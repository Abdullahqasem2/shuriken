package com.axsos.event.shuriken.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axsos.event.shuriken.models.Role;
import com.axsos.event.shuriken.models.User;
import com.axsos.event.shuriken.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	 private UserRepository userRepository;
	    
	    public UserDetailsServiceImplementation(UserRepository userRepository){
	        this.userRepository = userRepository;
	    }
	    // 1
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	        
	        if(user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	    }
	    
	    // 2
	    private List<GrantedAuthority> getAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for(Role role : user.getRoles()) {
	            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
	            authorities.add(grantedAuthority);
	        }
	        return authorities;
	    }
}
