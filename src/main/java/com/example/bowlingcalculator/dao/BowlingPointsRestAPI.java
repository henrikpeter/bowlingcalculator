package com.example.bowlingcalculator.dao;

import com.example.bowlingcalculator.model.Points;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class BowlingPointsRestAPI {

    private static Logger log = LoggerFactory.getLogger(BowlingPointsRestAPI.class);

    public Points getBowlingPoints() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String pointsResourceUrl = "http://13.74.31.101/api/points";
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(pointsResourceUrl, String.class);
        }catch (Exception e){
            log.error("resource could not be received from rest endpoint: {}", e.getMessage());
            throw e;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue((response.getBody()), Points.class);
        } catch (Exception e) {
            log.error("error in mapping response {}",e.getMessage());
            throw e;
        }
    }


}
