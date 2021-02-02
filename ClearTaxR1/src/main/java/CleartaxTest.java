import analyser.Analyser;
import analyser.JavaCodeAnalyser;
import analyser.LineByLineAnalyser;
import input.CodeFileReader;

import java.io.IOException;
import java.util.List;

public class CleartaxTest {


    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\vikram\\Documents\\creating-your-first-micronaut-app-master\\untitled\\src\\main\\java\\CleartaxTest.java";
        CodeFileReader fileReader = new CodeFileReader();
        List<String> lines = fileReader.readFile(path);
        /**
         * This is entire file analyser
         */
        Analyser codeAnalyser = new JavaCodeAnalyser(lines);
        System.out.println("Blank Lines : " + codeAnalyser.getBlankLines());
        System.out.println("Commented Lines :" + codeAnalyser.getCommentedLines());
        System.out.println("Multiline Comments :" + codeAnalyser.getMultilineComments());
        System.out.println("Total Lines of File : " + codeAnalyser.getTotalLines());
        System.out.println("Total lines of code : " + codeAnalyser.getCodeLines());

        /**
         * This is line by line analyser
         */
        LineByLineAnalyser lineAnalyser = new LineByLineAnalyser();
        for (String line : lines) {
            lineAnalyser.processLine(line);
        }
        System.out.println(lineAnalyser.getFileStatistics());
    }
}
