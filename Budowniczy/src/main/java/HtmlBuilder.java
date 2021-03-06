/**
 * Created by ${Robert} on 01.06.2016.
 */
public class HtmlBuilder implements MiddleBuilder {
    private String document;
    public String build() {
        return document;
    }

    public void closeDocument() {
        document+="\n</html>";
    }

    public void beginDocument() {
        document+="<html>\n";
    }

    public void addLine() {
        document+="\n<hr>";
    }

    public void addParagraph(String text) {
        document+="\n<p><center>"+text+"</center></p>";
    }

    @Override
    public void generateMiddle(String text) {
        addLine();
        addLine();
        addLine();
        addParagraph(text);
    }
}
