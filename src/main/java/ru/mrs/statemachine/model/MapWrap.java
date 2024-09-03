package ru.mrs.statemachine.model;

import ru.mrs.statemachine.model.enumerated.Catalog;
import ru.mrs.statemachine.model.enumerated.MyObject;

import java.util.*;
import java.util.stream.Collectors;

public class MapWrap {

    private final Map<Catalog, EnumSet<MyObject>> mapCatalogMyObject = new HashMap<>();

    {
        Map<MyObject, MyObject> myObject = new HashMap<>();
        for (MyObject myObj : EnumSet.allOf(MyObject.class)) {
            myObject.put(myObj, myObj);
        }
        Map<Catalog, Catalog> catalog = new HashMap<>();
        for (Catalog cat : EnumSet.allOf(Catalog.class)) {
            catalog.put(cat, cat);
        }
        mapCatalogMyObject.put(
                catalog.remove(Catalog.LOCATION),
                EnumSet.of(
                        myObject.remove(MyObject.LOCATION),
                        myObject.remove(MyObject.SPACE),
                        myObject.remove(MyObject.BUILDING),
                        myObject.remove(MyObject.FLOOR),
                        myObject.remove(MyObject.LAND) ) );
    }

}
