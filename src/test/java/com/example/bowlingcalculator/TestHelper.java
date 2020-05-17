package com.example.bowlingcalculator;

import com.example.bowlingcalculator.model.Frame;
import com.example.bowlingcalculator.model.Points;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static  List<Frame> getAllFrames(){
        Points points = new Points();
        ArrayList<List<Integer>> listArrayList = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(0,3);
        integerList1.add(1,7);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(0,10);
        integerList2.add(1,0);

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(0,8);
        integerList3.add(1,2);

        List<Integer> integerList4 = new ArrayList<>();
        integerList4.add(0,8);
        integerList4.add(1,1);

        List<Integer> integerList5 = new ArrayList<>();
        integerList5.add(0,10);
        integerList5.add(1,0);

        List<Integer> integerList6 = new ArrayList<>();
        integerList6.add(0,3);
        integerList6.add(1,4);

        List<Integer> integerList7 = new ArrayList<>();
        integerList7.add(0,7);
        integerList7.add(1,0);

        List<Integer> integerList8 = new ArrayList<>();
        integerList8.add(0,5);
        integerList8.add(1,5);

        List<Integer> integerList9 = new ArrayList<>();
        integerList9.add(0,3);
        integerList9.add(1,2);

        List<Integer> integerList10 = new ArrayList<>();
        integerList10.add(0,5);
        integerList10.add(1,5);
        integerList10.add(2,7);

        listArrayList.add(0,integerList1);
        listArrayList.add(1,integerList2);
        listArrayList.add(2,integerList3);
        listArrayList.add(3,integerList4);
        listArrayList.add(4,integerList5);
        listArrayList.add(5,integerList6);
        listArrayList.add(6,integerList7);
        listArrayList.add(7,integerList8);
        listArrayList.add(8,integerList9);
        listArrayList.add(9,integerList10);

        points.setPoints(listArrayList);

        List<Frame> frameList = new ArrayList<>();
        for (List<Integer> integerList : points.getPoints()) {
            Frame frame = new Frame();
            frame.setPinsKnockedDownRollOne(integerList.get(0));
            frame.setPinsKnockedDownRollTwo(integerList.get(1));
            if (integerList.size() == 3) {
                //we have the 10'th frame with extra roll
                frame.setExtraFinalRoll(integerList.get(2));
            }
            frameList.add(frame);
        }

        return frameList;
    }


    public static Points getPointsNotAllFrames(){
        Points points = new Points();
        ArrayList<List<Integer>> listArrayList = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(0,3);
        integerList1.add(1,7);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(0,10);
        integerList2.add(1,0);

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(0,8);
        integerList3.add(1,2);

        List<Integer> integerList4 = new ArrayList<>();
        integerList4.add(0,8);
        integerList4.add(1,1);

        List<Integer> integerList5 = new ArrayList<>();
        integerList5.add(0,10);
        integerList5.add(1,0);

        listArrayList.add(0,integerList1);
        listArrayList.add(1,integerList2);
        listArrayList.add(2,integerList3);
        listArrayList.add(3,integerList4);
        listArrayList.add(4,integerList5);

        points.setPoints(listArrayList);

        return points;
    }

    public static Points getPointsAllFrames(){
        Points points = new Points();
        ArrayList<List<Integer>> listArrayList = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(0,3);
        integerList1.add(1,7);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(0,10);
        integerList2.add(1,0);

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(0,8);
        integerList3.add(1,2);

        List<Integer> integerList4 = new ArrayList<>();
        integerList4.add(0,8);
        integerList4.add(1,1);

        List<Integer> integerList5 = new ArrayList<>();
        integerList5.add(0,10);
        integerList5.add(1,0);

        List<Integer> integerList6 = new ArrayList<>();
        integerList6.add(0,3);
        integerList6.add(1,4);

        List<Integer> integerList7 = new ArrayList<>();
        integerList7.add(0,7);
        integerList7.add(1,0);

        List<Integer> integerList8 = new ArrayList<>();
        integerList8.add(0,5);
        integerList8.add(1,5);

        List<Integer> integerList9 = new ArrayList<>();
        integerList9.add(0,3);
        integerList9.add(1,2);

        List<Integer> integerList10 = new ArrayList<>();
        integerList10.add(0,2);
        integerList10.add(1,5);

        listArrayList.add(0,integerList1);
        listArrayList.add(1,integerList2);
        listArrayList.add(2,integerList3);
        listArrayList.add(3,integerList4);
        listArrayList.add(4,integerList5);
        listArrayList.add(5,integerList6);
        listArrayList.add(6,integerList7);
        listArrayList.add(7,integerList8);
        listArrayList.add(8,integerList9);
        listArrayList.add(9,integerList10);

        points.setPoints(listArrayList);

        return points;
    }


}
