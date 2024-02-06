package cft.pchelkin.Constants;

public enum Options {
    FILE_DIRECTORY ("-o"), //задает путь куда сохраняется файл
    FILE_PREFIX ("-p"), //задает префикс перед сохранием файла
    FILE_SHORT_STATISTICS ("-s"), //задает вывод короткой статистики по файлу
    FILE_FULL_STATISTICS ("-f"), //задает вывод полной статистики
    FILE_SAVE ("-a"); //задает вывод в сущестующие файлы
    private final String option;
    Options(String option ) {
        this.option = option;
    }
    public String getOption() {
        return option;
    }
}