package com.testremember.security;

import com.testremember.model.User;
import com.testremember.repository.Repositories;
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



    Repositories repositories;

    public UserDetail(Repositories repositories) {
        this.repositories = repositories;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        // Получаем User из БД для проверки
        User user = repositories.getUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getAuthorities());

    }


    private Collection<? extends GrantedAuthority> getAuthorities(){

        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

    }




}