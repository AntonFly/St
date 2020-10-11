package lab1.test;

import lab1.main.BucketSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {
    BucketSort sort = new BucketSort();
    int numberOfElement= 10;


    @Test
    public void blackBoxSortTest() throws IllegalAccessException {
        int[] a= new int[numberOfElement];
        for(int i=0; i< numberOfElement; i++){
            a[i]= (int) Math.round(Math.random()*100);
        }
        int[] sorted =Arrays.copyOf(a,a.length);
        Arrays.sort(sorted);
        int[] modSorted =sort.makeSort(a);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(modSorted));
        assertArrayEquals("Модуль работает неправильно", sorted, modSorted);
    }

    @Test
    public void whiteBoxSortTest() throws IllegalAccessException {

        int[] a= new int[numberOfElement];
        sort.log="";
        String log="";
        for(int i=0; i< numberOfElement; i++){
            a[i]= (int) Math.round(Math.random()*100);
        }
        int max=0;
        for(int i=0;i < numberOfElement;i++){
            if (a[i] > max)
                max= a[i];
        }
        for(int i=0;i < numberOfElement;i++){
            double j = (double) a[i]*numberOfElement/(max+1);
            log=log.concat(Integer.toString((int)j));
        }
        int[] modSorted =sort.makeSort(a);
        assertEquals("Модуль работает неправильно", log, sort.log);
    }
}
