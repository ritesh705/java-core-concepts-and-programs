package com.ritesh.java.concepts.java8.collectionimprovement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionImprovement
{
    public static void main(String[] args)
    {
        testCollectionImprovement();
    }

    private static void testCollectionImprovement()
    {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");

        map.replace("a", "A", "C");
        map.replace("c", "C", "A");

        List<Map.Entry<String,String>> list = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        list.forEach(System.out :: println);
    }
}
