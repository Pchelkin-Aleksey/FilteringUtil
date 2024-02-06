package cft.pchelkin.Model;

import cft.pchelkin.View.ShowException;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutFileWriter {
    String filePath;
    public OutFileWriter(String filePath){
        this.filePath = filePath;
    }

    public void writeFiles(@NotNull List<String> strings, boolean rewrite){
        try (FileWriter writer = new FileWriter(filePath, rewrite)){
            for (String text : strings){
               writer.write(text);
               writer.write("\n");
            }
        }
        catch (IOException e) {
            ShowException.showExFileCreate();
            System.exit(0);
        }
    }
}