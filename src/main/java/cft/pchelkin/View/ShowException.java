package cft.pchelkin.View;

import cft.pchelkin.Constants.Constants;

public class ShowException {
    private ShowException(){}
    public static void showExFileInOut(){
        System.out.println(Constants.EXCEPTION_FILE_ABSENT);
    }
    public static void showExFileCreate(){
        System.out.println(Constants.EXCEPTION_FILE_CREATE);
    }

}
