package com.vikram.singh.springbootjdbc.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiExceptionModel(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
}
