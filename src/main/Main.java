package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arccos Arc = new Arccos();
        BucketSort sort = new BucketSort();
        int[] a= new int[10];
        for(int i=0; i< 10; i++){
            a[i]= (int) Math.round(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        try {
            System.out.println(Arrays.toString(sort.makeSort(a)));
        } catch (IllegalAccessException e) {
            System.out.println("Неверный массив");
            e.printStackTrace();
        }
    }
}
