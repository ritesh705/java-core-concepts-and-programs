package com.ritesh.ds.java8;

import java.util.ArrayList;
import java.util.List;

public class ForEach
{
    public static void main(String[] args)
    {
        List list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        list.add("test04");
        list.add("test05");

        // Java 8 For Each Loop
        list.forEach(obj -> System.out.println(obj));
    }
}
