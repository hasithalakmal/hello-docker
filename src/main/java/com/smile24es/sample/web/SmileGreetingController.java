package com.smile24es.sample.web;

import com.smile24es.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller class for testing
 * <p>
 * Created by hasithag
 * on 1/12/19.
 */
@RestController
public class SmileGreetingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmileGreetingController.class);


    @Autowired
    private SampleService sampleService;

    /**
     * The endpoint to demonstrate traditional greeting
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/traditional/greetings", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String traditionalGreeting() {

        LOGGER.info("Received request for traditional greeting");
        return sampleService.greetingWithoutName();
    }



}
