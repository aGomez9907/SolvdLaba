package com.Alejo.ArrayChallenge;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        double[] toOrder = getArray(5);//calling the method to enter the numbers for the array and declaring the array length
        printArray(sortArray(toOrder));//ordering and printing the array
    }

// A method to read the array by console
    public static double[] getArray(int length){
        double[] array = new double[length];
        System.out.println("Enter "+ length + "numbers: ");
        for (int i=0; i<array.length;i++){
            array[i] = scanner.nextDouble();
        }

        return array;

    }
// A method to print the array
    public static void printArray(double[] array){

        for (int i=0; i<array.length;i++){
            System.out.println("Element "+ i + " contents "+ array[i]);
        }
    }
//A method to sort the array from grater to minor (insertion sort)
    public static double[] sortArray(double[] toSort){
        double auxDouble;
        for (int i=0; i<toSort.length; i++){
            for (int j=i+1; j<toSort.length; j++){//compares the element i with the rest of the elements
                if (toSort[i]<toSort[j]){       // if finds one element greater than element i switches them
                    auxDouble = toSort[i];      //after the first iteration in the first for ends the first element of the array is the gratest
                    toSort[i] = toSort[j];
                    toSort [j] = auxDouble;
                }
            }
        }
        return toSort;
    }
}
