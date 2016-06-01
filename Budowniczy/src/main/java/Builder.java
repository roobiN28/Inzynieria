/**
 * Created by ${Robert} on 01.06.2016.
 */
public interface Builder {
    void addParagraph(String text);
    void addLine();
    void beginDocument();
    void closeDocument();
    String build();
}
