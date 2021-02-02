package analyser;

import java.util.List;

public interface Analyser {

    public long getCommentedLines();
    public long getMultilineComments();
    public long getCodeLines();
    public long getBlankLines();
    public long getTotalLines();
}
