package com.example.bowlingcalculator;

import com.example.bowlingcalculator.model.Frame;
import com.example.bowlingcalculator.model.Points;
import com.example.bowlingcalculator.model.TotalScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    /**
     * @param points
     * @return
     */
    public TotalScore calculateBowlingTotalScore(Points points) {
        TotalScore totalScore = new TotalScore();
        totalScore.setToken(points.getToken());

        List<Frame> frameList = new ArrayList<>();
        for (List<Integer> integerList : points.getPoints()) {
            Frame frame = new Frame();
            frame.setPinsKnockedDownRollOne(integerList.get(0));
            frame.setPinsKnockedDownRollTwo(integerList.get(1));
            frame.setTotalScore(frame.getPinsKnockedDownRollOne() + frame.getPinsKnockedDownRollTwo());
            frameList.add(frame);
        }


        if (frameList.size() < 10) {
            // we have not received a full set of frames. we do not calculate with bonus for strike and spare
            List<Integer> toalScoreList = new ArrayList<>();
            int totalSum = 0;
            for (Frame frame : frameList) {
                int rollOneAndTwo = frame.getPinsKnockedDownRollOne() + frame.getPinsKnockedDownRollTwo();
                totalSum = totalSum + rollOneAndTwo;
                toalScoreList.add(totalSum);
            }
            totalScore.setToalScore(toalScoreList);
        } else {
            // we have received a full set of frames. we have to calculate with bonus for strike and spare.
            totalScore.setToalScore(recalculateFrames(points));
            ;
        }

        return totalScore;
    }

    /**
     * @param points
     * @return List<Integer>
     */
     List<Integer> recalculateFrames(Points points) {
        List<Frame> frameList = new ArrayList<>();
        for (List<Integer> integerList : points.getPoints()) {
            Integer rollOne = integerList.get(0);
            Integer rollTwo = integerList.get(1);
            Frame frame = new Frame();
            frame.setPinsKnockedDownRollOne(rollOne);
            frame.setPinsKnockedDownRollTwo(rollTwo);
            if (rollOne == 10 || rollTwo == 10) {
                //we have a strike
                frame.setStrike(true);
            } else {
                //check to see if we have a spare
                if (rollOne + rollTwo == 10) {
                    frame.setSpare(true);
                }
            }
            frameList.add(frame);
        }

        //now we calculate to total score for all frames with bonus
        List<Integer> totalScoreList = new ArrayList<>();
        int totalScore = 0;
        int index = 0;
        while (index < 10) {
            if (frameList.get(index).isStrike() == false && frameList.get(index).isSpare() == false) {
                //we can already calculate the score
                int sumOfrollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfrollOneAndTwo;
                totalScoreList.add(totalScore);
            }
            if (frameList.get(index).isSpare()) {
                //we have to read the values of the next object in framelist in order to calculate.
                int nextIndex;
                if (index == 9) {
                    nextIndex = index;
                } else {
                    nextIndex = index + 1;
                }
                int bonus = frameList.get(nextIndex).getPinsKnockedDownRollOne();
                int sumOfrollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfrollOneAndTwo + bonus;
                totalScoreList.add(totalScore);
            }
            if (frameList.get(index).isStrike()) {
                //we have to read the values of the next object in framelist in order to calculate.
                int nextIndex;
                if (index == 9) {
                    nextIndex = index;
                } else {
                    nextIndex = index + 1;
                }
                int bonus = frameList.get(nextIndex).getPinsKnockedDownRollOne() + frameList.get(index + 1).getPinsKnockedDownRollTwo();
                int sumOfrollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfrollOneAndTwo + bonus;
                totalScoreList.add(totalScore);
            }
            index++;
        }
        return totalScoreList;
    }
}
