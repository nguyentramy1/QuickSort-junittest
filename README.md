# Kiểm thử nâng cao với JUnit - Bài toán sắp xếp

Dự án này chứa thuật toán **QuickSort** được triển khai trong Java. Các bài kiểm thử được viết bằng JUnit để kiểm tra tính đúng đắn của các thuật toán.

## Nội dung dự án

- **Algorithms.java**: Chứa thuật toán (QuickSort).
- **AlgorithmsTest.java**: Các bài kiểm thử JUnit cho thuật toán.
- **pom.xml**: Cấu hình Maven cho dự án.

## Thuật toán

Thuật toán **QuickSort** là một thuật toán sắp xếp nhanh, sử dụng phương pháp phân chia và chinh phục để phân chia mảng và sắp xếp các phần tử.

**Thuật toán**:
1. Chọn một phần tử làm pivot.
2. Phân chia mảng sao cho các phần tử nhỏ hơn pivot nằm bên trái, lớn hơn pivot nằm bên phải.
3. Đệ quy sắp xếp các phần tử bên trái và bên phải của pivot.

### Mã nguồn:

**Algorithms.java**:

```java
public class Algorithms {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

```
## Các trường hợp kiểm thử
testQuickSortWithEmptyArray: Kiểm thử với mảng rỗng.
testQuickSortWithSingleElement: Kiểm thử với mảng chỉ có một phần tử.
testQuickSortWithMultipleCases: Kiểm thử với các mảng có nhiều phần tử, sử dụng các giá trị khác nhau.

### Mã nguồn:
``` java
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
```
## Kết quả test
![image](https://github.com/user-attachments/assets/40354d14-73e8-4888-89d6-9a0f32b1b19e)
## Test coverage
![image](https://github.com/user-attachments/assets/6ac70569-7d58-42da-80ae-0ceaefaae6d3)

## Tác giả
Nguyễn Trà My
## Tham khảo
https://chatgpt.com/share/67808564-5bb8-8006-ba75-eb68165f9528
