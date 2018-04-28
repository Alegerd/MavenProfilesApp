package com.alegerd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid login data.")
public class WrongLoginException extends Exception {

    public WrongLoginException() {
    }
}
