package analyser;

import java.util.List;
import java.util.PriorityQueue;

public class JavaCodeAnalyser implements Analyser{

    private long singleLineComment;
    private long multilineComment;
    private long emptyLines;
    private long totalLines;
    private long codeLines;
    private List<String> lines;

    public JavaCodeAnalyser(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public long getCommentedLines() {
        if(singleLineComment != 0)
            return singleLineComment;
        String pattern = "//";
        singleLineComment = lines.stream().filter(line -> line.contains(pattern)).count();
        return singleLineComment;
    }

    @Override
    public long getMultilineComments() {
        if(multilineComment != 0){
            return multilineComment;
        }
        String startPattern = "/*";
        String endPattern = "*/";
        int startIndex = 0, count = 0;
        for (int i = 0; i <lines.size(); i++) {
            if(lines.get(i).contains(startPattern)){
                startIndex = i;
            } else if(lines.get(i).contains(endPattern)){
                count += i - startIndex;
                startIndex = 0;
            }
        }
        multilineComment = count;
        return count;
    }

    @Override
    public long getCodeLines() {
        codeLines = totalLines - getBlankLines() - getCommentedLines() - getMultilineComments();
        return codeLines;
    }

    @Override
    public long getBlankLines() {
        if (emptyLines != 0)
            return emptyLines;
        emptyLines = lines.stream().filter(line -> line.isBlank()).count();
        return emptyLines;
    }

    @Override
    public long getTotalLines() {
        if (totalLines != 0)
            return totalLines;
        totalLines =  lines.size();
        return totalLines;
    }
}
