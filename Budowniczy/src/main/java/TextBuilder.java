/**
 * Created by ${Robert} on 01.06.2016.
 */
public class TextBuilder implements Builder {
    private String document;
    public void addParagraph(String text) {
        document+=text+"\n";
    }

    public void addLine() {
        document+="----------------------------\n";
    }

    public void beginDocument() {

    }

    public void closeDocument() {

    }

    public String build() {
        return null;
    }
}
