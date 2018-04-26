package com.alegerd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User Already Sined In")
public class UserAlreadySinedInException extends Exception{

    public UserAlreadySinedInException() {
    }
}
