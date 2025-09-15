package co.com.siigo.web;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {}
