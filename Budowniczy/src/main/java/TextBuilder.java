/**
 * Created by ${Robert} on 01.06.2016.
 */
public class TextBuilder implements MiddleBuilder {
    private String document = "";
    public void addParagraph(String text) {
        document+=text+"\n";
    }

    public void addLine() {
        document+="---------------------------- \n";
    }

    public void beginDocument() {
        document+="\n";
    }

    public void closeDocument() {
        document+="\n";
    }

    public String build() {
        return document;
    }

    @Override
    public void generateMiddle(String text) {
        addLine();
        addParagraph(text);
    }
}
