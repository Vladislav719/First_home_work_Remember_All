package com.github.vladislav719.structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;

/**
 * Created by vladislav on 07.09.14.
 */
public class Utils {

    private static List<Aeroflot> aeroflots = new ArrayList<Aeroflot>();

    public static List<Aeroflot> readObject(String path) throws FileNotFoundException {
        return readObject(new File(path));
    }

    public static List<Aeroflot> readObject(File file) throws FileNotFoundException {
        List<String> fileStrings;
        try {
            fileStrings = FileUtils.readLines(file);
            for (String line : fileStrings){
                Aeroflot aero = new Aeroflot();
                String[] token = line.split("&");
                if (token.length != 4)
                    break;
                aero.setDeparture(token[0]);
                aero.setDestination(token[1]);
                aero.setFlightNumber(Integer.parseInt(token[2]));
                aero.setType(AircraftTypes.valueOf(token[3]));
                aeroflots.add(aero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeroflots;
    }

    public static Set<Map.Entry<Integer, String>> displaySearchResult(String destination) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Aeroflot x : aeroflots) {
            if (x.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                map.put(x.getFlightNumber(), AircraftTypes.getDisplayNames(x.getType()));
            }
        }
        return map.entrySet();
    }

    public static List<Aeroflot> showTopFlight() {
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

        for (Aeroflot x : aeroflots) {
            String dest = x.getDestination();
            if (!frequencyMap.containsKey(dest)) {
                frequencyMap.put(dest, 1);
            } else {
                frequencyMap.put(dest, frequencyMap.get(dest)+1);
            }
        }

//        ValueComparator vC = new ValueComparator(frequencyMap);

        //if need max value
        Map.Entry<String, Integer> maxV = null;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet())
            if (maxV == null || entry.getValue().compareTo(maxV.getValue()) > 0)
                maxV = entry;
//        TreeMap<String, Integer> sortedFlights = new TreeMap<String, Integer>(vC);
//        sortedFlights.putAll(frequencyMap);
        List<Aeroflot> newList = new LinkedList<Aeroflot>();

        for (Aeroflot x : aeroflots) {
            if ( x.getDestination().toLowerCase()
                    .equals(maxV.getKey().toLowerCase()) )
                newList.add(x);
        }
        return newList;
    }


    /**
     * это для вывода топ листа - вывод рейсов в порядке убывания их востребованности
     */
    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> map;

        public ValueComparator(Map<String, Integer> map) {
            this.map = map;
        }

        public int compare(String a, String b) {
            if (map.get(a) >= map.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }


}
