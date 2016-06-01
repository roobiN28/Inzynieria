import Files.FileWorker;

import java.util.List;

/**
 * Created by ${Robert} on 01.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        String fileNameToRead = "text";
        String fileNameHtmlToWrite = "blog.html";
        String fileNameArticleToWrite = "article.txt";
        List<String> text = FileWorker.getAllLinesFromFile(fileNameToRead);
        Director director = new Director();
        FileWorker.saveInFile(director.generateArticle(text) , fileNameArticleToWrite);
        FileWorker.saveInFile(director.generateBlog(text) , fileNameHtmlToWrite);



    }
}
