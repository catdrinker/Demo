package range;

import java.util.Arrays;

/**
 * 选择排序通过
 *
 * 0(N^2)
 *
 * 每一轮从剩余数组里选择最大的数，移动到该轮的位置
 *
 * 重复 len -1 次
 *
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = {12, 5, 16, 4223, 54, 657, 32, 188, 97, 6};
        selection(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    public static void selection(int[] arr) {
        int len = arr.length;

        int maxIndex;
        for (int i = 0; i < len - 1; i++) {
            maxIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }


    }
}
