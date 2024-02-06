package cft.pchelkin.Model;

import cft.pchelkin.View.ShowException;
import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InFileAnalyzer {

    private final String path;
    private final List<String> strings = new ArrayList<>();
    private final List<String> integers = new ArrayList<>();
    private final List<String> floats = new ArrayList<>();

    public InFileAnalyzer(String path) {
        this.path = path;
        dataInit();
    }
    public List<String> getStrings() {
        return strings;
    }

    public List<String> getIntegers() {
        return integers;
    }

    public List<String> getFloats() {
        return floats;
    }

    @NotNull
    private List<String> getContent(){
        List<String> contentList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";

            while (line != null) {
                line = br.readLine();
                contentList.add(line);
            }
        } catch (IOException e) {
            ShowException.showExFileInOut();
            System.exit(0);
        }
        return contentList;
    }

    private void dataInit() {
        for (String arg : getContent()){
            if(isInteger(arg)) integers.add(arg);
            else if (isFloat(arg)) floats.add(arg);
            else if (arg != null) strings.add(arg);
        }
    }

    private boolean isInteger(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) { return false; }
    }

    private boolean isFloat(String s) throws NumberFormatException{
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) { return false; }
    }
}