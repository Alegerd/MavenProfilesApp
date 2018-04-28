package com.alegerd.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    public void loginUser(String username, String password){
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails != null) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(password,
                    userDetails.getAuthorities());

            authenticationManager.authenticate(token);

            if(token.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }
    }
}
