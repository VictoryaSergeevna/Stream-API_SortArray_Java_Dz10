package com.company;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Заполните массив 10 целыми числами");
        Integer[]arr = new Integer[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }


        Set<Integer> set = Arrays.stream(arr).sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toSet());
        Comparator<Integer> customComp = (a,b) -> {
            if(set.contains(a) && set.contains(b)){ return a.compareTo(b);}
            else if(set.contains(a)){ return 1;}
            else if(set.contains(b)){ return -1;}
            else { return 0;}
        };
        int[] sorted = Arrays.stream(arr).sorted(customComp.reversed()).limit(5).mapToInt(i->i).toArray();
        System.out.println("Отсортированный массив в обратном порядке из 5 чисел:");
        System.out.println(Arrays.toString(sorted));




    }
}
