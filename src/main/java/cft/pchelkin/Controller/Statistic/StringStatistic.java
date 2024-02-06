package cft.pchelkin.Controller.Statistic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringStatistic {
    private final List<String> stringList;
    public StringStatistic(List<String> stringList){
        this.stringList = stringList;
    }
    public String getLongString(){
        return Collections.max(stringList, Comparator.comparing(String::length));
    }
    public String getShortString(){
        return Collections.min(stringList, Comparator.comparing(String::length));
    }

}