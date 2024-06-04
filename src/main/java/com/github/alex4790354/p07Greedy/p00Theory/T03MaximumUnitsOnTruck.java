package com.github.alex4790354.p07Greedy.p00Theory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T03MaximumUnitsOnTruck {

    public static void main(String[] args) {
        int[][] boxTypes = {{35,14},{57,99},{70,48},{50,70},{59,24},{48,72},{27,48},{50,89},{91,9},{87,66},{74,58},{52,29},{10,19},{11,87},{56,71},{83,67},{73,31},{41,58},{26,39},{100,99},{96,51},{33,34},{43,23},{22,41},{89,28},{43,19},{87,56},{30,95},{54,93},{81,98},{84,26},{51,52},{21,16}};
        int truckSize = 270;
        T03MaximumUnitsOnTruck test = new T03MaximumUnitsOnTruck();
        System.out.println(test.maximumUnits(boxTypes, truckSize));
        System.out.println(test.maximumUnits2(boxTypes, truckSize));
    }

    private int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitsInTruck = 0, boxesInTruck = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            pq.offer(box);
        }
        for (int[] box : pq) {
            System.out.println(Arrays.toString(box));
        }

        for (int[] box : pq) {
            if (boxesInTruck + box[0] < truckSize) {
                boxesInTruck += box[0];
                unitsInTruck += box[1] * box[0];
            } else {
                unitsInTruck += box[1] * (truckSize - boxesInTruck);
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

        int maxUnits = 0;
        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            if (truckSize >= numberOfBoxes) {
                // Если можем взять все коробки данного типа
                maxUnits += numberOfBoxes * unitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                // Если можем взять только часть коробок
                System.out.println("truckSize: " + truckSize + ", unitsPerBox: " + unitsPerBox);
                maxUnits += truckSize * unitsPerBox;
                break; // Грузовик заполнен
            }
        }

        return maxUnits;
    }

}
