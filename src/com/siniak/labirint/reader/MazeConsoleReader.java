package com.siniak.labirint.reader;

import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MazeConsoleReader extends AbstractReader{

    public List<String> readMaze(String path) {
        List<String> lines = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(true){
            String current = scan.nextLine();
            if(current.equals("")){
                break;
            }
            lines.add(current);
        }
        return lines;
    }
}
