package com.myunica.first.controller;

import com.myunica.first.dto.KafkaDTO;
import com.myunica.first.service.UnicaHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@Slf4j
@Validated
@RequiredArgsConstructor
public class KafkaListeners {

    private final UnicaHandler unicaHandler;

    @KafkaListener(topics = "unica_topic", groupId = "unica_group", containerFactory = "kafkaFactory")
    public void listener(@Valid KafkaDTO request) {
        log.info("\n\n" + "A " + request.getType() + " request has been received from kafka!\n\n");

        unicaHandler.sendRequest(request);
    }
}
