package lab1.main;

import java.util.*;

public class BucketSort {

    public String log="";

    public int[] makeSort(int[] initArray) throws IllegalAccessException {
        if(initArray == null)
            throw new NullPointerException();
        int numberOfElement = initArray.length;
        ArrayList<Integer>[] subArray = new ArrayList[numberOfElement];
        for (int i = 0; i < numberOfElement; i++) {
            subArray[i] = new ArrayList<Integer>();
        }

        int max=0;

        for(int i=0;i < numberOfElement;i++){
            if (initArray[i] > max)
                max= initArray[i];
        }

        for(int i=0;i<numberOfElement; i++){
            double j = (double) initArray[i]*numberOfElement/(max+1);
            log=log.concat(Integer.toString((int)j));
            if (subArray[(int)j].isEmpty())
                subArray[(int)j].add(initArray[i]);
            else
                for(int k = 0; k<subArray[(int)j].size(); k++){
                    double coef = (double)subArray[(int)j].get(k)*numberOfElement/(max+1);
                    if( j<=coef) {
                        subArray[(int) j].add(k,initArray[i]);
                        break;
                    }
                    if(k == subArray[(int)j].size()-1 && j>coef){
                        subArray[(int)j].add(initArray[i]);
                        break;
                    }
//                    if(initArray[i]>subArray[j].get(k) && initArray[i]<=subArray[j].get(k+1)){
//                        subArray[j].add(k+1);
//                        break;
//                    }
//                    if(initArray[i]<=subArray[j].get(0)){
//                        subArray[j].add(k,initArray[i]);
//                        break;
//                    }
//                    if(initArray[i]>subArray[j].get(subArray[j].size()-1))
//                        subArray[j].add(subArray[j].size(),initArray[i]);
                }

            }
        int k=0;
        for(int j = 0; j<initArray.length; j++  ){
            if(subArray[j].isEmpty())
                continue;
            ListIterator<Integer> iter = subArray[j].listIterator();
            while (iter.hasNext()){
                initArray[k]= iter.next();
                k++;
            }
        }

        return initArray;
    }

}
