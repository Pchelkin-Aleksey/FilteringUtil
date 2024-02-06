package cft.pchelkin.Controller;

import cft.pchelkin.Constants.Constants;
import cft.pchelkin.Constants.Options;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RequestParser {
    private final String optionsString;
    private String filePath = null;
    private String filePrefix = null;
    private final List<Options> optionsList = new ArrayList<>();
    private final List<String> listInputFiles = new ArrayList<>();
    public RequestParser(String optionsString) {
        this.optionsString = optionsString;
        stringParser();
    }
    public List<Options> getOptionsList() {
        return optionsList;
    }
    public String getFileDirectory() {
        return filePath;
    }
    public String getFilePrefix() {
        return filePrefix;
    }
    public List<String> getListInTxt(){
        return listInputFiles;
    }
    @NotNull
    @Contract(pure = true)
    public String[] getWords(){
        return optionsString.split(" ");
    }

    public void stringParser(){
        for(String arg : getWords()){
            Options option = getOption(arg);
            if (option != null) optionsList.add(option);
            else if(checkFilePath(arg)) filePath = arg;
            else if (checkInputFiles(arg)) listInputFiles.add(arg);
            else if(checkPrefix(arg)) filePrefix = arg;
        }
        correctFinalPath();
    }

    private void correctFinalPath(){
        if (filePath == null) filePath = Constants.DEFOLIATE_PATH;
        else if (filePath.indexOf(filePath.length()-1) != '\\') filePath += "\\";
    }

    private boolean checkInputFiles(@NotNull String string){
        return string.contains(".txt");
    }
    private  boolean checkFilePath(@NotNull String string){
        return string.contains("\\") && string.contains(":\\");
    }
    private boolean checkPrefix(@NotNull String string){
        return !string.contains("\\") && !string.contains(".txt") && (getOption(string) == null);
    }
    @Nullable
    private Options getOption(@NotNull String arg){
        if (arg.equals(Options.FILE_SAVE.getOption())){
            return Options.FILE_SAVE;
        }
        else if (arg.equals(Options.FILE_PREFIX.getOption())){
            return Options.FILE_PREFIX;
        }
        else if(arg.equals(Options.FILE_SHORT_STATISTICS.getOption())){
            return Options.FILE_SHORT_STATISTICS;
        }
        else if(arg.equals(Options.FILE_FULL_STATISTICS.getOption())){
            return Options.FILE_FULL_STATISTICS;
        }
        else if(arg.equals(Options.FILE_DIRECTORY.getOption())){
            return Options.FILE_DIRECTORY;
        }
        return null;
    }
}