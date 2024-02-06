package cft.pchelkin.Constants;

import cft.pchelkin.Controller.RequestExecutor;

public class Constants {
    private Constants(){}
    public static final String NAME_FILE_STRING = "strings.txt";
    public static final String NAME_FILE_FLOAT = "floats.txt";
    public static final String NAME_FILE_INTEGER = "integers.txt";
    public static final String DEFOLIATE_PATH = "C:\\";
    public static final String SHOW_NUMBER_GIVEN_STRING = "Количество записанных строк - ";
    public static final String SHOW_MIN_VALUE = "Минимальное значение - ";
    public static final String SHOW_MAX_VALUE = "Максимальное значение - ";
    public static final String SHOW_MEAN_VALUE = "Среднеарифметическое значение - ";
    public static final String SHOW_SUM_VALUE = "Сумма всех чисел - ";
    public static final String SHOW_LONG_STRING = "Самая длинная строка - ";
    public static final String SHOW_SHORT_STRING = "Самая короткая строка - ";
    public static final String SHOW_FLOAT_STAT = "Статистика по файлу - " + RequestExecutor.getNameFilePrefix(NAME_FILE_FLOAT);
    public static final String SHOW_INTEGER_STAT = "Статистика по файлу - " + RequestExecutor.getNameFilePrefix(NAME_FILE_INTEGER);
    public static final String SHOW_STRING_STAT = "Статистика по файлу - " + RequestExecutor.getNameFilePrefix(NAME_FILE_STRING);
    public static final String EXCEPTION_FILE_ABSENT = "Ошибка! Файлы с данными не соответствуют параметрам!";
    public static final String EXCEPTION_FILE_CREATE = "Ошибка! при создании файла" + "\n" + "!Синтаксическая ошибка в имени файла, имени папки или метке тома";
}