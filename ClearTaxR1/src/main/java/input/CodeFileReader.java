package input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CodeFileReader {

    public List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }


}
