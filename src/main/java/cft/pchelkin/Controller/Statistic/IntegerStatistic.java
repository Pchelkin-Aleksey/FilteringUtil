package cft.pchelkin.Controller.Statistic;

import java.util.List;

public class IntegerStatistic {
    private final List<String> intList;
    public IntegerStatistic(List<String> floatList){
        this.intList = floatList;
    }
    public long getMaxNumber(){
        return intList.stream()
                .map(Long::parseLong)
                .max(Long::compareTo).get();
    }

    public long getMinNumber(){
        return intList.stream()
                .map(Long::parseLong)
                .min(Long::compareTo).get();
    }

    public long getSumOfNumber(){
        return intList.stream()
                .map(Long::parseLong)
                .reduce(0L,Long::sum);
    }

    public long getMeanNumber(){
        return getSumOfNumber() / intList.size();
    }
}
