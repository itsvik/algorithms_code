package analyser;

import model.FileStats;

import java.util.List;

public class LineByLineAnalyser {
    private long singleLineComment;
    private long multilineComment;
    private long emptyLines;
    private long totalLines;
    private long codeLines;
    private List<String> lines;

    public void processLine(String line){
        getBlankLines(line);
        getCommentedLines(line);
        getMultilineComments(line);
        getTotalLines();
        getCodeLines();
    }

    public FileStats getFileStatistics(){
        return new FileStats()
                .setCodeLines(codeLines)
                .setEmptyLines(emptyLines)
                .setTotalLines(totalLines)
                .setMultilineComment(multilineComment)
                .setSingleLineComment(singleLineComment);
    }


    private long getCommentedLines(String line) {

        String pattern = "//";
        if(line.contains(pattern)){
            singleLineComment++;
        }
        return singleLineComment;
    }


    private long getMultilineComments(String line) {

        String startPattern = "/*";
        String endPattern = "*/";
        int startIndex = -1;
        if(line.contains(startPattern) && startIndex == -1){
            multilineComment++;
            startIndex = 0;
        } else if(line.contains(endPattern)){
            startIndex = -1;
        } else if(startIndex != -1){
            multilineComment++;
        }
        return multilineComment;
    }


    private long getCodeLines() {
        codeLines = totalLines - emptyLines - singleLineComment - multilineComment;
        return codeLines;
    }

    private long getBlankLines(String line) {
        if(line.isBlank()){
            emptyLines++;
        }
        return emptyLines;
    }

    private long getTotalLines() {
        return totalLines++;
    }
}
