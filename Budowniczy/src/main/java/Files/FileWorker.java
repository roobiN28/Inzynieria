package Files;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class FileWorker {
    private static String basicPath = "src/main/resources/";

    public static List<String> getAllLinesFromFile(String filename) {
        try{
           return Files.readAllLines(Paths.get(basicPath + filename));
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
    public static void saveInFile(String text, String filename) {
        try {
            Path path =  Paths.get(basicPath + filename);
            Charset charset = Charset.forName("Unicode");

            BufferedWriter bw = Files.newBufferedWriter(path,charset,StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            bw.write(text);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
