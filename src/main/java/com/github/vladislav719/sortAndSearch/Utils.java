package com.github.vladislav719.sortAndSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by vladislav on 07.09.14.
 */
public class Utils {

    static ArrayList list = new ArrayList();

    public static String readFile(String path) throws IOException {
        return new Scanner(new File(path)).useDelimiter("\\Z").next().replaceAll("\\n","").replaceAll("[\"}{\\s]","");
    }

    public static int getIndex(String word) throws IOException {
        Collections.addAll(list, readFile("/home/vladislav/libgdx/Remember all or why summer is over/src/main/resources/arr.dat").split(","));
        return list.indexOf(word);
    }
}
