package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writing {
    private String path;
    private boolean append = true;

    public Writing(String path) {
        this.path = path;
    }

    public Writing(String path, boolean append_value) {
        this.path = path;
        this.append = append_value;
    }

    public void writeToFile(String message) throws IOException {
        FileWriter write = new FileWriter(path, append);
        PrintWriter printLine = new PrintWriter(write);

        printLine.printf("%s" + "%n", message);

        printLine.close();
    }


    public static void clearFile(String FileName) throws IOException {
        FileWriter fwOb = new FileWriter(FileName, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}
