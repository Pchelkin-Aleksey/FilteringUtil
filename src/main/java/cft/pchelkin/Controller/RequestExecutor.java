package cft.pchelkin.Controller;

import cft.pchelkin.Constants.Constants;
import cft.pchelkin.Constants.Options;
import cft.pchelkin.Model.InFileAnalyzer;
import cft.pchelkin.Model.OutFileWriter;
import cft.pchelkin.View.ShowStatistic;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RequestExecutor {
    private final String request;
    private static RequestParser parser;
    private final List<String> resultListString = new ArrayList<>();
    private final List<String> resultListFloat = new ArrayList<>();
    private final List<String> resultListInteger = new ArrayList<>();
    public RequestExecutor(String request) {
        this.request = request;
        init();
    }
    private void init() {
        parser = new RequestParser(request);
        initDataTypeList();
        showStatistic();
    }

    public void createFiles() {
        writeFile(resultListFloat, Constants.NAME_FILE_FLOAT);
        writeFile(resultListInteger, Constants.NAME_FILE_INTEGER);
        writeFile(resultListString, Constants.NAME_FILE_STRING);
    }

    private void writeFile(@NotNull List<String> resultList, String nameFile) {
        OutFileWriter writer;
        if(!resultList.isEmpty()){
            writer = new OutFileWriter(resultPathString(nameFile));
            writer.writeFiles(resultList, parser.getOptionsList().contains(Options.FILE_SAVE));
        }
    }

    private void initDataTypeList() {
        List<String> query = parser.getListInTxt();
        InFileAnalyzer file;
        StringBuilder builder = new StringBuilder();
        builder.append(parser.getFileDirectory());
        for (String nameInFile : query) {
            file = new InFileAnalyzer(builder.append(nameInFile).toString());
            resultListString.addAll(file.getStrings());
            resultListFloat.addAll(file.getFloats());
            resultListInteger.addAll(file.getIntegers());
            builder.delete(parser.getFileDirectory().length(), parser.getFileDirectory().length() + nameInFile.length());
        }
    }

    private void showStatistic() {
        if (parser.getOptionsList().contains(Options.FILE_FULL_STATISTICS)){
            if (!resultListFloat.isEmpty()) ShowStatistic.showFullFloatStatistic(resultListFloat);
            if (!resultListInteger.isEmpty()) ShowStatistic.showFullIntegerStatistic(resultListInteger);
            if (!resultListString.isEmpty()) ShowStatistic.showFullStringStatistic(resultListString);
        }
        if (parser.getOptionsList().contains(Options.FILE_SHORT_STATISTICS)){
            if (!resultListFloat.isEmpty()) {
                System.out.println(Constants.SHOW_FLOAT_STAT);
                ShowStatistic.showShortStatistic(resultListFloat);
            }
            if (!resultListInteger.isEmpty()){
                System.out.println(Constants.SHOW_INTEGER_STAT);
                ShowStatistic.showShortStatistic(resultListInteger);
            }
            if (!resultListString.isEmpty()){
                System.out.println(Constants.SHOW_STRING_STAT);
                ShowStatistic.showShortStatistic(resultListString);
            }
        }
    }

    public static String getNameFilePrefix(String nameFile){
        if (parser.getFilePrefix() != null && parser.getOptionsList().contains(Options.FILE_PREFIX)) nameFile = parser.getFilePrefix()+nameFile;
        return nameFile;
    }

    @NotNull
    private String resultPathString(String nameFile) {
        StringBuilder builder = new StringBuilder();
        if (parser.getFileDirectory() != null) builder.append(parser.getFileDirectory());
        else builder.append(Constants.DEFOLIATE_PATH);
        builder.append(getNameFilePrefix(nameFile));
        return builder.toString();
    }
}