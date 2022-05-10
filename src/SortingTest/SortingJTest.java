package SortingTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingJTest {

    @Test
    void AscendingSortTest() {
        SortingTest sort = new SortingTest(6,true);
        Integer[] integerArray = { 10, 55, -5, 34, 7, 22, 19 };
        SortingTest.ShellSort(integerArray, integerArray.length);
        Assertions.assertEquals(-5, integerArray[0]);
    }

    @Test
    void DescendingSortTest() {
        SortingTest sort = new SortingTest(6,true);
        Integer[] integerArray = { 10, 55, -5, 34, 7, 22, 19 };
        SortingTest.DownShellSort(integerArray, integerArray.length);
        Assertions.assertEquals(55, integerArray[0]);
        Assertions.assertEquals(34, integerArray[1]);
        Assertions.assertEquals(22, integerArray[2]);
        Assertions.assertEquals(-5, integerArray[6]);
    }
}
