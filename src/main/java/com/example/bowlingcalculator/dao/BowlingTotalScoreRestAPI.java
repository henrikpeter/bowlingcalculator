package com.example.bowlingcalculator.dao;

import com.example.bowlingcalculator.model.TotalScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BowlingTotalScoreRestAPI {

    private static Logger log = LoggerFactory.getLogger(BowlingTotalScoreRestAPI.class);

    public HttpStatus validateTotalScore(TotalScore totalScore) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<TotalScore> request = new HttpEntity<>(totalScore);
        ResponseEntity<TotalScore> response = null;
        try {
            response = restTemplate.exchange("http://13.74.31.101/api/points", HttpMethod.POST, request, TotalScore.class);
            return response.getStatusCode();
        } catch (Exception e) {
            log.error("Total score could not be validated: {}", e.getMessage());
            throw e;
        }
    }
}
