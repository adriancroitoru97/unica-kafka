package com.myunica.first.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OffersService {
    ResponseEntity<?> getOffers(final Integer sessionID, final String IP);
    ResponseEntity<?> getOffersForMultipleIP(final Integer sessionID, final List<String> IPs);
}
