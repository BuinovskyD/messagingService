package ru.buinovsky.subscriber.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.buinovsky.subscriber.model.MessageTo;
import ru.buinovsky.subscriber.service.MassageService;

@RestController
public class MassageController {

    private final MassageService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(MassageController.class);

    public MassageController(MassageService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody MessageTo message) {
        LOGGER.info("create message with action {}", message.getAction());
        service.create(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
