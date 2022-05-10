package SortingTest;

import java.io.*;
import java.util.Arrays;

public class SortingTest {
    public static int ARRAY_SIZE = 100;
    public static boolean ASCENDING = false;
    static boolean SAVE_DATA = true;
    public static int MEASURING_QUANTITY = 200;

    public SortingTest(int i, boolean ASCENDING) {
        ARRAY_SIZE = i;
        SortingTest.ASCENDING =ASCENDING;
    }

    public static void ShellSort ( Integer[] a , int len )
    {
        for (int step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                for (int j = i - step; j >= 0 && a[j] > a[j + step] ; j -= step) {
                    int temp = a[j];
                    a[j] = a[j + step];
                    a[j + step] = temp;
                }
            }
        }
    }
    public static void DownShellSort ( Integer[] a , int len )
    {
        for (int step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                for (int j = i - step; j >= 0 && a[j] < a[j + step] ; j -= step) {
                    int temp = a[j];
                    a[j] = a[j + step];
                    a[j + step] = temp;
                }
            }
        }
    }

    public static <T> void fillArray(RandomElementGenerator<T> generator, T[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.generate(i);
        }
    }

    public static Integer[] createAndFill() {
        Integer[] array = new Integer[ARRAY_SIZE];
        fillArray(index -> (int) (Math.random() * 200), array);
        return array;
    }

    static <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);
            if (i + 1 != array.length) {
                System.out.print(", ");
            }

        }
        System.out.print("]");
        System.out.println();
    }

    static <T> void saveData() throws IOException {
        try (FileWriter fw = new FileWriter("data.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            long[] timeArray = new long[MEASURING_QUANTITY];
            if (ASCENDING) {
                for (int i = 0; i < MEASURING_QUANTITY; i++) {
                    Integer[] array = createAndFill();
//                    bw.write(Arrays.toString(array) + "\n");
                    long startTime = System.nanoTime();
                    ShellSort(array, array.length);
                    long endTime = System.nanoTime();
//                    bw.write(Arrays.toString(array) + "\n");
                    timeArray[i] = (endTime - startTime)/1000;
                }
            } else {
                for (int i = 0; i < MEASURING_QUANTITY; i++) {
                    Integer[] array = createAndFill();
//                    bw.write(Arrays.toString(array)+"\n");
                    long startTime = System.nanoTime();
                    DownShellSort(array, array.length);
                    long endTime = System.nanoTime();
//                    bw.write(Arrays.toString(array)+"\n");
                    timeArray[i] = (endTime - startTime)/1000;
                }
            }
            bw.write("Array containing the values of the element Ascending/Descending Shell sorting time measurements in some of MEASURING_QUANTITY arrays ");
            bw.write("\n"+Arrays.toString(timeArray));
//            System.out.println(Arrays.toString(timeArray));
            long averageSortTime = Arrays.stream(timeArray).sum()/ timeArray.length;
            bw.write("\nAverage time = " + averageSortTime+ " microseconds ");
            int random = (int) (Math.random()*100);
            bw.write("\n" + timeArray[random]+" - random ShellSorted array`s time");
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException {
        if (SAVE_DATA) {
            saveData();
        }
        Integer[] testArray = createAndFill();
        System.out.println("Shell Sorting Example \n");
        System.out.println(Arrays.toString(testArray));
        long startTime2 = System.nanoTime();
        DownShellSort(testArray,testArray.length);
        long endTime2 = System.nanoTime();
        System.out.println("\n"+Arrays.toString(testArray));
        System.out.println("\n"+"Time = "+(endTime2-startTime2)/1000+ " microseconds ");
    }
}
