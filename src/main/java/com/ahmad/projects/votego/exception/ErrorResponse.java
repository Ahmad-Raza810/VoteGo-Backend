package com.ahmad.projects.votego.exception;

import lombok.*;

@Setter
@Getter
public class ErrorResponse {

    public ErrorResponse( String message ,int statusCode) {
        this.statusCode = statusCode;
        this.message = message;
    }

    private String message;
    private int statusCode;
}
