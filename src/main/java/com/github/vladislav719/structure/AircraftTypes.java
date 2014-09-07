package com.github.vladislav719.structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Baimurzin Vladislav
 *          07.09.14.
 *          P.S. инфу по самолетам брал здесь https://en.wikipedia.org/wiki/Airliner
 */
public enum AircraftTypes {
    WIDE_BODY,
    NARROW_BODY,
    REGIONAL,
    COMMUTER;

    private static Map<AircraftTypes, String> displayNames = new LinkedHashMap<AircraftTypes, String>(){{
        put(WIDE_BODY, "Широкофюзеляжный");
        put(NARROW_BODY, "Широкофюзеляжный");
        put(REGIONAL, "Региональный");
        put(COMMUTER, "Местный");
    }};

    public static String getDisplayNames(AircraftTypes type) {
        return displayNames.get(type);
    }
}
