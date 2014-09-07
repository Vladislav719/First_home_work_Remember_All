package com.github.vladislav719.sortAndSearch;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by vladislav on 07.09.14.
 */
public class Main {



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(Utils.getIndex(s) == -1 ? "Нет такого элемента"  : Utils.getIndex(s));
        }
    }

}
