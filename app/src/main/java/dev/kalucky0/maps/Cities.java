package dev.kalucky0.maps;

import org.osmdroid.util.GeoPoint;

import java.util.HashMap;
import java.util.Map;

public class Cities {
    public static final Map<String, GeoPoint> list = new HashMap<String, GeoPoint>() {{
        put("Frombork", new GeoPoint(82.89, -107.93));
        put("Gdańsk", new GeoPoint(82.88f, -118.86f));
        put("Gdynia", new GeoPoint(83.24, -119.83));
        put("Hel", new GeoPoint(83.6, -118.5));
        put("Kartuzy", new GeoPoint(82.84, -123.5));
        put("Kościerzyna", new GeoPoint(82.34, -125.76));
        put("Kraków", new GeoPoint(63f, -104.25f));
        put("Malbork", new GeoPoint(82.13, -114.66));
        put("Międzyzdroje", new GeoPoint(82.09, -163.6));
        put("Ostrołęka", new GeoPoint(79.49f, -87.33f));
        put("Poznań", new GeoPoint(76.97f, -137.91f));
        put("Sopot", new GeoPoint(83.08, -119.63));
        put("Tczew", new GeoPoint(82.28, -117.35));
        put("Warszawa", new GeoPoint(76.23f, -92.9f));
        put("Wrocław", new GeoPoint(70.49f, -137.45f));
        put("Świnoujście", new GeoPoint(82.04, -165.62));
    }};
}
