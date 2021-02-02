package model;

public class FileStats {
    private long singleLineComment;
    private long multilineComment;
    private long emptyLines;
    private long totalLines;
    private long codeLines;

    public long getSingleLineComment() {
        return singleLineComment;
    }

    public FileStats setSingleLineComment(long singleLineComment) {
        this.singleLineComment = singleLineComment;
        return this;
    }

    public long getMultilineComment() {
        return multilineComment;
    }

    public FileStats setMultilineComment(long multilineComment) {
        this.multilineComment = multilineComment;
        return this;
    }

    public long getEmptyLines() {
        return emptyLines;
    }

    public FileStats setEmptyLines(long emptyLines) {
        this.emptyLines = emptyLines;
        return this;
    }

    public long getTotalLines() {
        return totalLines;
    }

    public FileStats setTotalLines(long totalLines) {
        this.totalLines = totalLines;
        return this;
    }

    public long getCodeLines() {
        return codeLines;
    }

    public FileStats setCodeLines(long codeLines) {
        this.codeLines = codeLines;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FileStats{");
        sb.append("singleLineComment=").append(singleLineComment);
        sb.append(", multilineComment=").append(multilineComment);
        sb.append(", emptyLines=").append(emptyLines);
        sb.append(", totalLines=").append(totalLines);
        sb.append(", codeLines=").append(codeLines);
        sb.append('}');
        return sb.toString();
    }
}
