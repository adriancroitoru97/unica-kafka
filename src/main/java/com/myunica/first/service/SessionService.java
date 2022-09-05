package com.myunica.first.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    ResponseEntity<?> startSession(final Integer sessionID);
    ResponseEntity<?> endSession(final Integer sessionID);
}
