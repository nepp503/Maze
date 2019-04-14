package com.siniak.labirint;

import com.siniak.labirint.creator.WayCreator;
import com.siniak.labirint.exception.IncorrectInputDataException;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        WayCreator creator = new WayCreator();
        List<String> wayOut = new ArrayList<>();
        try {
            wayOut = creator.createWayOut("input/input.txt");
        } catch (IncorrectInputDataException exception) {
            System.out.println("Incorrect input data");
        }
        System.out.println(wayOut);
    }
}
