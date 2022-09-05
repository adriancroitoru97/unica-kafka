package com.myunica.first.service;

import com.myunica.first.dto.CallType;
import com.myunica.first.dto.KafkaDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaProducers {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void sendKafkaMessages () {

        KafkaDTO startSession = KafkaDTO.builder()
                .id(589)
                .type(CallType.START_SESSION)
                .build();
        kafkaTemplate.send("unica_topic", startSession);


        KafkaDTO getOffers = KafkaDTO.builder()
                .id(589)
                .type(CallType.GET_OFFERS)
                .interactionPoint("TrainingIP")
                .build();
        kafkaTemplate.send("unica_topic", getOffers);


        KafkaDTO getOffersForMultipleIPs = KafkaDTO.builder()
                .id(589)
                .type(CallType.GET_OFFERS_FOR_MULTIPLE_IPS)
                .multipleIPs(Arrays.asList("TrainingIP", "TrainingIP"))
                .build();
        kafkaTemplate.send("unica_topic", getOffersForMultipleIPs);


        KafkaDTO postEvent = KafkaDTO.builder()
                .id(589)
                .type(CallType.POST_EVENT)
                .treatmentCodes(List.of("1ed8.d2.4d25fa3.4d25fa3"))
                .build();
        kafkaTemplate.send("unica_topic", postEvent);


        KafkaDTO endSession = KafkaDTO.builder()
                .id(589)
                .type(CallType.END_SESSION)
                .build();
        kafkaTemplate.send("unica_topic", endSession);
    }
}
