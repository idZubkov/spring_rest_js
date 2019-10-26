package Strategy;

import java.util.Arrays;

public class StrategyTest {
    public static void main(String[] args) {
        StrategyClient sc = new StrategyClient();

        int[] array0 = {5, -1, 3, 0, 9};
        sc.setSorting(new SelectionSort());
        sc.executeStrategy(array0);

        int[] array1 = {66, 3, 132, 4, 2, -23, -4, 2};
        sc.setSorting(new InsertionSort());
        sc.executeStrategy(array1);

        int[] array2 = {33, 22, 67, 45, 3, 23, 234, 2, 354, 5, 2};
        sc.setSorting(new BubbleSort());
        sc.executeStrategy(array2);
    }

}

class StrategyClient {
    private Sorting sorting;

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }

    void executeStrategy(int[] array) {
        sorting.sort(array);
    }
}

interface Sorting {
    void sort(int[] array);
}

class BubbleSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Bubble sort:");
        System.out.println("Array before sort:\t" + Arrays.toString(array));
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array after BUBBLESORT:\t" + Arrays.toString(array));
    }
}

class InsertionSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Insertion sort:");
        System.out.println("Array before sort:\t" + Arrays.toString(array));
        int j, temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
        System.out.println("Array after INSERTIONSORT:\t" + Arrays.toString(array));
    }
}

class SelectionSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Selection sort:");
        System.out.println("Array before sort:\t" + Arrays.toString(array));
        int minValue, minIndex, temp;
        for (int i = 0; i < array.length; i++) {
            minValue = array[i];
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if (minValue < array[i]) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        System.out.println("Array after SELECTIONSORT:\t" + Arrays.toString(array));
    }
}