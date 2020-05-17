package com.example.bowlingcalculator;

import com.example.bowlingcalculator.model.Frame;
import com.example.bowlingcalculator.model.Points;
import com.example.bowlingcalculator.model.TotalScore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testRecalculateFrames() {
        //setup
        List<Frame> frameList = TestHelper.getAllFrames();
        //run test
        List<Integer> calculatorIntegerList = calculator.recalculateFrames(frameList);
        //check code
        assertEquals(Integer.valueOf(20), calculatorIntegerList.get(0));
        assertEquals(Integer.valueOf(40), calculatorIntegerList.get(1));
        assertEquals(Integer.valueOf(58), calculatorIntegerList.get(2));
        assertEquals(Integer.valueOf(67), calculatorIntegerList.get(3));
        assertEquals(Integer.valueOf(84), calculatorIntegerList.get(4));
        assertEquals(Integer.valueOf(91), calculatorIntegerList.get(5));
        assertEquals(Integer.valueOf(98), calculatorIntegerList.get(6));
        assertEquals(Integer.valueOf(111), calculatorIntegerList.get(7));
        assertEquals(Integer.valueOf(116), calculatorIntegerList.get(8));
        assertEquals(Integer.valueOf(123), calculatorIntegerList.get(9));
    }


    @Test
    public void testCalculateBowlingTotalScore() {
        //setup
        Points points = TestHelper.getPointsNotAllFrames();
        //run test
        TotalScore totalScore = calculator.calculateBowlingTotalScore(points);
        //check code
        assertEquals(Integer.valueOf(10), totalScore.getToalScore().get(0));
        assertEquals(Integer.valueOf(20), totalScore.getToalScore().get(1));
        assertEquals(Integer.valueOf(30), totalScore.getToalScore().get(2));
        assertEquals(Integer.valueOf(39), totalScore.getToalScore().get(3));
        assertEquals(Integer.valueOf(49), totalScore.getToalScore().get(4));

    }


    @Test
    public void testCalculateBowlingTotalScoreAllFrames() {
        //setup
        Points points = TestHelper.getPointsAllFrames();
        //run test
        TotalScore totalScore = calculator.calculateBowlingTotalScore(points);
        //check code
        assertEquals(Integer.valueOf(20), totalScore.getToalScore().get(0));
        assertEquals(Integer.valueOf(40), totalScore.getToalScore().get(1));
        assertEquals(Integer.valueOf(58), totalScore.getToalScore().get(2));
        assertEquals(Integer.valueOf(67), totalScore.getToalScore().get(3));
        assertEquals(Integer.valueOf(84), totalScore.getToalScore().get(4));
        assertEquals(Integer.valueOf(91), totalScore.getToalScore().get(5));
        assertEquals(Integer.valueOf(98), totalScore.getToalScore().get(6));
        assertEquals(Integer.valueOf(111), totalScore.getToalScore().get(7));
        assertEquals(Integer.valueOf(116), totalScore.getToalScore().get(8));
        assertEquals(Integer.valueOf(123), totalScore.getToalScore().get(9));

    }
}