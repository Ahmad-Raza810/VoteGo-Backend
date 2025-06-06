package com.ahmad.projects.votego.exception;

public class VoteNotAllowedException extends RuntimeException {
    public VoteNotAllowedException(String message) {
        super(message);
    }
}
