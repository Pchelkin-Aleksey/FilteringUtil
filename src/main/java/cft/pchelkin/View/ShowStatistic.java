package cft.pchelkin.View;

import cft.pchelkin.Constants.Constants;
import cft.pchelkin.Controller.Statistic.FloatStatistic;
import cft.pchelkin.Controller.Statistic.IntegerStatistic;
import cft.pchelkin.Controller.Statistic.StringStatistic;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ShowStatistic {
   private ShowStatistic(){}
    public static void showFullFloatStatistic(List<String> floatList){
        FloatStatistic floatStatistic = new FloatStatistic(floatList);
        System.out.println(Constants.SHOW_FLOAT_STAT);
        showShortStatistic(floatList);
        System.out.println(Constants.SHOW_MIN_VALUE + floatStatistic.getMinNumber());
        System.out.println(Constants.SHOW_MAX_VALUE + floatStatistic.getMaxNumber());
        System.out.println(Constants.SHOW_MEAN_VALUE + floatStatistic.getMeanNumber());
        System.out.println(Constants.SHOW_SUM_VALUE + floatStatistic.getSumOfNumber());
        System.out.println("\n");
    }
    public static void showFullIntegerStatistic(List<String> intList){
        IntegerStatistic intStatistic = new IntegerStatistic(intList);
        System.out.println(Constants.SHOW_INTEGER_STAT);
        showShortStatistic(intList);
        System.out.println(Constants.SHOW_MIN_VALUE + intStatistic.getMinNumber());
        System.out.println(Constants.SHOW_MAX_VALUE + intStatistic.getMaxNumber());
        System.out.println(Constants.SHOW_MEAN_VALUE + intStatistic.getMeanNumber());
        System.out.println(Constants.SHOW_SUM_VALUE + intStatistic.getSumOfNumber());
        System.out.println("\n");
    }
    public static void showFullStringStatistic(List<String> stringList){
        StringStatistic stringStatistic = new StringStatistic(stringList);
        System.out.println(Constants.SHOW_STRING_STAT);
        showShortStatistic(stringList);
        System.out.println(Constants.SHOW_LONG_STRING + stringStatistic.getLongString());
        System.out.println(Constants.SHOW_SHORT_STRING + stringStatistic.getShortString());
        System.out.println("\n");
    }
    public static void showShortStatistic(@NotNull List<String> strings){
        System.out.println(Constants.SHOW_NUMBER_GIVEN_STRING + strings.size());
    }
}