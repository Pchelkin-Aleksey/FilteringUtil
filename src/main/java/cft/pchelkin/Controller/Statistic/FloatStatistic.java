package cft.pchelkin.Controller.Statistic;

import java.util.List;

public class FloatStatistic {
    private final List<String> floatList;
    public FloatStatistic(List<String> floatList){
        this.floatList = floatList;
    }

    public float getMaxNumber(){
        return floatList.stream()
                        .map(Float::parseFloat)
                        .max(Float::compareTo).get();
    }

    public float getMinNumber(){
        return floatList.stream()
                .map(Float::parseFloat)
                .min(Float::compareTo).get();
    }

    public float getSumOfNumber(){
        return floatList.stream()
                .map(Float::parseFloat)
                .reduce(0.0f, Float::sum);
    }

    public float getMeanNumber(){
        return getSumOfNumber()/ floatList.size();
    }

}
