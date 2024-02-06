package cft.pchelkin;

import cft.pchelkin.Controller.RequestExecutor;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        System.out.println("Введите запрос: " );
        Scanner in = new Scanner(System.in);
        String enterString = in.nextLine();
        RequestExecutor requestExecutor = new RequestExecutor(enterString);
        requestExecutor.createFiles();
    }
}