package com.robin.bank.data;

import lombok.extern.log4j.Log4j;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class FileWorker {


    public List<String> getAllLinesFromFile(String filename) {
        try{
           return Files.readAllLines(Paths.get(filename));
        }catch(IOException e){
            log.error("IOException when reading file: "+ filename);
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }
    public void AddOnEndOfLine(String text, String filename) {
        try {
            FileWriter fw = new FileWriter(filename,true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
