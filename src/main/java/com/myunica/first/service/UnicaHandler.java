package com.myunica.first.service;

import com.myunica.first.dto.KafkaDTO;
import com.myunica.first.service.impl.EventServiceImpl;
import com.myunica.first.service.impl.OffersServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UnicaHandler {
    private final SessionService sessionService;
    private final OffersServiceImpl offersServiceImpl;
    private final EventServiceImpl eventServiceImpl;

    public void sendRequest(KafkaDTO request) {

        ResponseEntity<?> unicaResponse =
                switch (request.getType()) {
                    case START_SESSION -> sessionService.startSession(request.getId());
                    case END_SESSION -> sessionService.endSession(request.getId());
                    case GET_OFFERS -> offersServiceImpl.getOffers(request.getId(), request.getInteractionPoint());
                    case GET_OFFERS_FOR_MULTIPLE_IPS ->
                            offersServiceImpl.getOffersForMultipleIP(request.getId(), request.getMultipleIPs());
                    case POST_EVENT -> eventServiceImpl.postEvent(request.getId(), request.getTreatmentCodes());
                };

        log.info("\n\n" + unicaResponse.toString() + "\n");
    }
}
