package com.example.bowlingcalculator;

import com.example.bowlingcalculator.dao.BowlingPointsRestAPI;
import com.example.bowlingcalculator.dao.BowlingTotalScoreRestAPI;
import com.example.bowlingcalculator.model.Points;
import com.example.bowlingcalculator.model.TotalScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private BowlingPointsRestAPI bowlingPointsRestAPI = new BowlingPointsRestAPI();
	private BowlingTotalScoreRestAPI bowlingTotalScoreRestAPI = new BowlingTotalScoreRestAPI();
	private Calculator calculator = new Calculator();

	private final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {

		log.info("application initiated.");

		Points points = bowlingPointsRestAPI.getBowlingPoints();
		showPoint(points);

		TotalScore totalScore = calculator.calculateBowlingTotalScore(points);
		showTotalScore(totalScore);

		HttpStatus httpStatus = bowlingTotalScoreRestAPI.validateTotalScore(totalScore);
        log.info("httpStatus code : {}",httpStatus.getReasonPhrase());

		log.info("application ended with success.");
	}

	private void showTotalScore(TotalScore totalScore) {
		for(Integer score : totalScore.getToalScore()){
			log.info("total score {}", score);
		}

		log.info("token - TotalScore: {}",totalScore.getToken());
	}

	private void showPoint(Points points) {
		for (List<Integer> integerList : points.getPoints()) {
			log.info("points {}, {}", integerList.get(0), integerList.get(1));
		}

		log.info("token - Points: {}",points.getToken());

	}

}
