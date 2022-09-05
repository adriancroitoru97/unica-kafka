package com.myunica.first.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    ResponseEntity<?> postEvent(final Integer sessionID, final List<String> treatmentCodes);
}
