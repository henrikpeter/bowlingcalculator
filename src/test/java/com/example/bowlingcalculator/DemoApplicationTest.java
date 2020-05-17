package com.example.bowlingcalculator;

import com.example.bowlingcalculator.dao.BowlingPointsRestAPI;
import com.example.bowlingcalculator.dao.BowlingTotalScoreRestAPI;
import com.example.bowlingcalculator.model.Points;
import com.example.bowlingcalculator.model.TotalScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTest {

    @InjectMocks
    private DemoApplication demoApplication;

    @Mock
    private BowlingPointsRestAPI mockedBowlingPointsRestAPI;

    @Mock
    private BowlingTotalScoreRestAPI mockedBowlingTotalScoreRestAPI;

    @Mock
    private Calculator mockedCalculator;


    @Test
    public void run() throws IOException {
        //setup
        String[] args = new String[0];
        Points points = TestHelper.getPointsAllFrames();
        TotalScore totalScore = new TotalScore();
        when(mockedBowlingPointsRestAPI.getBowlingPoints()).thenReturn(points);
        when(mockedCalculator.calculateBowlingTotalScore(points)).thenReturn(totalScore);
        when(mockedBowlingTotalScoreRestAPI.validateTotalScore(any())).thenReturn(HttpStatus.OK);
        //run test
        demoApplication.run(args);
        //check code
        verify(mockedBowlingPointsRestAPI, times(1)).getBowlingPoints();
        verify(mockedCalculator, times(1)).calculateBowlingTotalScore(any());
        verify(mockedBowlingTotalScoreRestAPI, times(1)).validateTotalScore(any());
    }
}