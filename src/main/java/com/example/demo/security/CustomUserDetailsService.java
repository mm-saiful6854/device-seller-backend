package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.add(SecurityUtils.convertToAuthority(user.getRole().name()));


        return UserPrincipal.builder().user(user).username(username)
                .password(user.getPassword()).authorities(authorities).build();
    }
}
