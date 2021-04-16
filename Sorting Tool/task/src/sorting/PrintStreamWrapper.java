package sorting;

import java.io.*;
import java.util.Optional;

public class PrintStreamWrapper implements AutoCloseable {

    private final PrintStream output;

    public PrintStreamWrapper(Optional<String> fileName) throws IOException {
        if (fileName.isEmpty()) {
            output = System.out;
        } else {
            output = new PrintStream(fileName.get());
        }
    }

    public void println(String str) {
        output.println(str);
    }

    @Override
    public void close() throws Exception {
        if (output != System.out) {
            output.close();
        }
    }
}
