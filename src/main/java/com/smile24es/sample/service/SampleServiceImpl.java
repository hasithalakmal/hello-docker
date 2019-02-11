package com.smile24es.sample.service;

import com.smile24es.sample.beans.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Override
    public String greetingWithoutName() {
        LOGGER.info("Start executing greeting");
        String greeting = Constants.GREETING;
        LOGGER.info("Exit from method greeting");
        return greeting;
    }
}
