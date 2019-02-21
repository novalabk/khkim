package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.HelloDao;
import com.example.domain.model.entity.Hello;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	HelloDao repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Hello hello = repository.findByName(username);
		System.out.println("username = " + username + " password = " + hello.getPassword());
		hello.setAuthorities(getAuthorities(username));
		return hello;
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = new ArrayList<String>();
        if(username.equals("a")){
        	string_authorities.add("ADMIN");
        }else{
        	string_authorities.add("USER");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
             authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
   }



}
