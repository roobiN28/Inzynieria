import lombok.Setter;

import java.util.List;

/**
 * Created by ${Robert} on 01.06.2016.
 */
public class Director {


    public Director() {
    }

    public String generateBlog(List<String> prototype) {
        MiddleBuilder builder = new HtmlBuilder();
        return generate(prototype, builder);

    }
    public String generateArticle(List<String> prototype) {
        Builder builder = new TextBuilder();
        return generate(prototype, (MiddleBuilder) builder);

    }
    private String generate(List<String> prototype, MiddleBuilder builder) {
        builder.beginDocument();
        for(String p : prototype) {
            builder.generateMiddle(p);
        }
        builder.closeDocument();
        return builder.build();

    }
    private void generateLines(Builder builder, int numberOfLines) {
        for(int i=0;i<numberOfLines;i++) {
            builder.addLine();
        }
    }

}
