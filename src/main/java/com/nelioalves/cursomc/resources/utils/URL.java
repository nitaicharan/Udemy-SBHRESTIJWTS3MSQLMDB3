package com.nelioalves.cursomc.resources.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    public static List<Integer> decodeIntList(String s) {
        List<String> list = Arrays.asList(s.split(","));

        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}