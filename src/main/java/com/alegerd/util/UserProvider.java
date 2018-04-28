package com.alegerd.util;

import com.alegerd.model.dto.UserDTO;
import com.alegerd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserProvider {

    @Autowired
    private UserService userService;

    public String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

    public UserDTO getAuthenticatedUser(){
        String username = getAuthenticatedUsername();
        return (username != null)? userService.findUserByUsername(username): null;
    }
}
