package com.github.vladislav719.structure;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.rmi.CORBA.Util;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladislav on 07.09.14.
 */
public class Main {

    public static void main(String[] args) {
        List<Aeroflot> aeroflotList = null;
        try {
            aeroflotList = Utils.readObject("resources/aero.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert aeroflotList != null;
        System.out.println("\n\n*********FROM FILE****************\n\n");
        for (Aeroflot x : aeroflotList)
            System.out.println(x.toString());

        aeroflotList = Utils.showTopFlight();
        System.out.println("\n\n*********************************TOP**********************************\n\n");
        for (Aeroflot x : aeroflotList)
            System.out.println(x.toString());

        System.out.println("Начните вводить пункт назначения, ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine())
            for (Map.Entry<Integer, String> x : Utils.displaySearchResult(sc.nextLine()))
                System.out.println(x.getKey() + " : " + x.getValue());
    }
}
