package com.ritesh.java.concepts.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stream
{
    public static void main(String[] args) {
        Stream testStream = new Stream();
        List<String> ip = Arrays.asList("AB", "BC", "AB", "CD", "DE");
        testStream.getCountMap(ip);
    }

    public Map<String, Integer> getCountMap(List<String> inputs)
    {
        Map<String, Integer > countMap = new HashMap<>();
        if(inputs != null && inputs.size() > 0)
        {
            /*for(String ip : inputs)
            {
                if(countMap.get(ip) != null)
                {
                    countMap.put(ip, countMap.get(ip)+1);
                }
                else
                {
                    countMap.put(ip, 1);
                }
            }*/

            inputs.stream().forEach(ip->
            {
                if(countMap.get(ip) != null)
                {
                    countMap.put(ip, countMap.get(ip)+1);
                }
                else
                {
                    countMap.put(ip, 1);
                }
            });
        }
        return countMap;
    }
}
