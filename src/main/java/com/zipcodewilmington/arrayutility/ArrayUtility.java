package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>{

    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int n = inputArray.length + arrayToMerge.length;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(i<=inputArray.length-1){
                if( inputArray[i].equals(valueToEvaluate))
                    counter++;
            }else{
                if( arrayToMerge[i-inputArray.length].equals(valueToEvaluate))
                    counter++;
            }
        }
        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Map<T, Integer> hp = new HashMap<>();
        for (T i:inputArray) {
            hp.put(i,getNumberOfOccurrences(i));
        }
        for (T i:arrayToMerge) {
            hp.put(i,getNumberOfOccurrences(i));
        }

        // find max frequency.
        int max_count = 0;
        T res = null;
        for(Map.Entry<T, Integer> val : hp.entrySet()) {
            if (max_count < val.getValue()) {
                res = val.getKey();
                max_count = val.getValue();
            }
        }
        return res;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;
        for (T element:inputArray) {
            if(element.equals(valueToEvaluate)){
             counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        List<T> arr = new ArrayList<>(Arrays.asList(inputArray));
        for (int i = 0; i < getNumberOfOccurrences(valueToRemove) ; i++) {
            arr.remove(valueToRemove);
        }
        T[] newCopy = Arrays.copyOf(inputArray,arr.size());
        //T[] newCopy =inputArray.clone;  won't work, probably bc it's a shallow copy
        return arr.toArray(newCopy);
    }
}
