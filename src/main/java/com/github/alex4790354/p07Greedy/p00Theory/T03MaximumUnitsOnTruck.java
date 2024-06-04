package com.github.alex4790354.p07Greedy.p00Theory;

import java.util.*;

public class T03MaximumUnitsOnTruck {

    public static void main(String[] args) {
        int[][] boxTypes = {{35,14},{57,99},{70,48},{50,70},{59,24},{48,72},{27,48},{50,89},{91,9},{87,66},{74,58},{52,29},{10,19},{11,87},{56,71},{83,67},{73,31},{41,58},{26,39},{100,99},{96,51},{33,34},{43,23},{22,41},{89,28},{43,19},{87,56},{30,95},{54,93},{81,98},{84,26},{51,52},{21,16}};
        int truckSize = 270;
        T03MaximumUnitsOnTruck test = new T03MaximumUnitsOnTruck();
        System.out.println(test.maximumUnits(boxTypes, truckSize));
        //System.out.println(test.maximumUnits2(boxTypes, truckSize));
    }

    private int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitsInTruck = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            pq.add(box);
        }

        while (pq.size() > 0) {
            int[] box = pq.poll();
            if (truckSize >= box[0]) {
                truckSize -= box[0];
                unitsInTruck += box[0] * box[1];
            } else {
                unitsInTruck += truckSize * box[1];
                break;
            }
        }
        return unitsInTruck;
    }

    private int maximumUnits2(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        List<Integer> truckSizeArray = new ArrayList<Integer>();
        List<Integer> unitsInTruckArray = new ArrayList<Integer>();

        int maxUnits = 0;
        for (int[] box : boxTypes) {
            System.out.println("##61: " + box[0] + ", " + box[1]);
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            if (truckSize >= numberOfBoxes) {
                // Если можем взять все коробки данного типа
                maxUnits += numberOfBoxes * unitsPerBox;
                truckSize -= numberOfBoxes;

                truckSizeArray.add(truckSize);
                unitsInTruckArray.add(maxUnits);
            } else {
                // Если можем взять только часть коробок
                //System.out.println("truckSize: " + truckSize + ", unitsPerBox: " + unitsPerBox);
                maxUnits += truckSize * unitsPerBox;

                truckSizeArray.add(truckSize);
                unitsInTruckArray.add(maxUnits);
                break; // Грузовик заполнен
            }
        }
        System.out.println("##79 truckSizeArray: " + truckSizeArray);
        System.out.println("##80 unitsInTruckArray: " + unitsInTruckArray);

        return maxUnits;
    }

}
