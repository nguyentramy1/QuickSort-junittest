import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlgorithmsTest {

    @Test
    void testQuickSortWithEmptyArray() {
        int[] arr = {};
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testQuickSortWithSingleElement() {
        int[] arr = {5};
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{5}, arr);
    }

    @ParameterizedTest
    @CsvSource({
            "'3,1,2', '1,2,3'",
            "'5,5,5,5', '5,5,5,5'",
            "'9,7,5,3,1', '1,3,5,7,9'"
    })
    void testQuickSortWithMultipleCases(String input, String expected) {
        int[] arr = parseArray(input);
        int[] expectedArr = parseArray(expected);
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expectedArr, arr);
    }

    private int[] parseArray(String input) {
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}
