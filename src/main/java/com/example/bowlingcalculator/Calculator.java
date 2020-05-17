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
     * This method makes a frame for each point pair.
     * If there are less than 10 frames, the total score is calculated without bonus point for strike and spare
     * If there are 10 frames (10 points pair -> finished game), the frames are recalculated with
     * bonus point for strike and spare.
     *
     * @param points
     * @return TotalScore
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
            totalScore.setToalScore(recalculateFrames(frameList));
        }

        return totalScore;
    }

    /**
     * This method recalculates all the frames where we take into account that some of the frames
     * have a strike or a spare.
     *
     * @param frameList
     * @return List<Integer>
     */
    List<Integer> recalculateFrames(List<Frame> frameList) {
        for (Frame frame : frameList) {
             if(frame.getPinsKnockedDownRollOne() == 10 || frame.getPinsKnockedDownRollTwo() == 10){
                 //we have a strike
                 frame.setStrike(true);
                 //we reset the score to 0 as we have to recalculate it.
                 frame.setTotalScore(0);
             }else{
                 //check to see if we have a spare
                 if(frame.getPinsKnockedDownRollOne() + frame.getPinsKnockedDownRollTwo() == 10){
                     frame.setSpare(true);
                     //we reset the score to 0 as we have to recalculate it.
                     frame.setTotalScore(0);
                 }
             }
        }

        //now we calculate to total score for all frames with bonus
        List<Integer> totalScoreList = new ArrayList<>();
        int totalScore = 0;
        int index = 0;
        while (index < 10) {
            int nextIndex;
            if (index == 9) {
                nextIndex = index;
            } else {
                nextIndex = index + 1;
            }

            if (frameList.get(index).isStrike() == false && frameList.get(index).isSpare() == false) {
                //we can already calculate the score
                int sumOfRollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfRollOneAndTwo;
                totalScoreList.add(totalScore);
            }
            if (frameList.get(index).isSpare()) {
                //we have to read the values of the next object in the frame list in order to calculate.
                //In the case of a spare the pins of the first roll have to be added as bonus
                int bonus = frameList.get(nextIndex).getPinsKnockedDownRollOne();
                int sumOfRollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfRollOneAndTwo + bonus;
                totalScoreList.add(totalScore);
            }
            if (frameList.get(index).isStrike()) {
                //we have to read the values of the next object in the frame list in order to calculate.
                //In the case of a strike the pins for the first roll and second roll have to be added as bonus
                int bonus = frameList.get(nextIndex).getPinsKnockedDownRollOne() + frameList.get(index + 1).getPinsKnockedDownRollTwo();
                int sumOfRollOneAndTwo = frameList.get(index).getPinsKnockedDownRollOne() + frameList.get(index).getPinsKnockedDownRollTwo();
                totalScore = totalScore + sumOfRollOneAndTwo + bonus;
                totalScoreList.add(totalScore);
            }
            index++;
        }
        return totalScoreList;
    }
}
