package com.ritesh.java.concepts.java8.streams;

import com.ritesh.java.concepts.java8.util.UserStats;

import java.util.*;
import java.util.stream.Collectors;

class ListOfMapToMap
{

    public static void main(String[] args)
    {
        List<Map<String, UserStats>> visits = getListOfMap();
        System.out.println("Before Java 8");
        countBeforeJava8(visits).entrySet().forEach(kv -> System.out.println(kv));
        System.out.println("In Java 8");
        countInJava8(visits).entrySet().forEach(kv -> System.out.println(kv));
    }

    private static List<Map<String, UserStats>> getListOfMap()
    {
        List<Map<String, UserStats>> visits = new ArrayList<>();
        // 1
        UserStats userStats1 = new UserStats();
        userStats1.setVisitCount(Optional.of(1L));
        //2
        UserStats userStats2 = new UserStats();
        userStats2.setVisitCount(Optional.of(1L));
        // 3
        UserStats userStats3 = new UserStats();
        userStats3.setVisitCount(Optional.of(5L));

        UserStats userStatsEmpty = new UserStats();

        Map<String, UserStats> visitMap1 = new HashMap();
        Map<String, UserStats> visitMap2 = new HashMap();
        Map<String, UserStats> visitMap3 = new HashMap();

        visitMap1.put(null, userStats1);
        visitMap1.put("9", null);

        visitMap1.put("1", userStats1);
        visitMap1.put("3", userStatsEmpty);
        visitMap2.put("1", userStats1);
        visitMap2.put("2", userStats2);
        visitMap3.put("2", userStats2);
        visitMap3.put("1", userStats3);

        visits.add(visitMap1);
        visits.add(visitMap2);
        visits.add(visitMap3);

        return visits;
    }

    static Map<Long, Long> countBeforeJava8(List<Map<String, UserStats>> visits)
    {
        Map<Long, Long> countMap = new HashMap<>();

        // Solution 01
        for (Map<String, UserStats> visitMap : visits)
        {
            if(visitMap != null)
            {
               for(String key : visitMap.keySet())
               {
                   if(key != null && !key.isEmpty() &&
                           visitMap.get(key) != null
                           && visitMap.get(key).getVisitCount() != null
                           && visitMap.get(key).getVisitCount().get() != null)
                   {
                       if(countMap.get(Long.parseLong(key)) != null)
                       {
                           Long totalCount = countMap.get(Long.parseLong(key))+visitMap.get(key).getVisitCount().get();
                           countMap.put(Long.parseLong(key), totalCount);
                       }
                       else
                       {
                           Long totalCount = visitMap.get(key).getVisitCount().get();
                           countMap.put(Long.parseLong(key), totalCount);
                       }
                   }
               }
            }
        }
        return countMap;
    }

    private static Map<Object, Object> countInJava8(List<Map<String, UserStats>> visits)
    {
        Map countMap = visits.stream()
                .flatMap(m->m.entrySet().stream())
                .filter(m -> m.getKey() != null
                        && !m.getKey().isEmpty()
                        && m.getValue() != null
                        && m.getValue().getVisitCount() != null
                        && m.getValue().getVisitCount().get() !=null)
                .collect(Collectors
                        .toMap(m->Long.parseLong(m.getKey()), m-> m.getValue().getVisitCount().get(),
                                Long::sum));
        return countMap;
    }
}

