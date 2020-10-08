package com.testremember.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetail implements UserDetailsService {





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new org.springframework.security.core.userdetails.User("user", "{noop}1111",
                true, true, true, true, getAuthorities());

    }


    private Collection<? extends GrantedAuthority> getAuthorities(){

        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

    }




}