package range;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 快速排序的思想是 从左往右找寻比target大的数字，找到 i 的值
 * <p>
 * 从右往左找寻比target小额数字，找到j的值
 * <p>
 * 每找到一组，将i，j的值交换，直到i>=j 结束
 * <p>
 * 结束后将i的值和target的值交换，一轮排序结束，
 * <p>
 * 分治法递归再去排target index 的左右，直到每个数组只有一个数
 */
public class Quick {

    public static void main(String[] args) {

//        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 52, 12};


        int a[] = { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1 };
//        int a[] = {47, 29, 71, 99, 78, 19, 24, 47};
        //  12 46, 20, 18, 65, 97, 82, 30, 77, 52,51

        //  12 46, 20, 18, 65, 97, 82, 51, 77, 52,30


        // 12 46, 20, 18, 51, 97, 82, 65, 77, 52,30

//        merge(a, 0, a.length - 1);
        quickSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            // 基准值
            int key = arr[begin];
            int i = begin;
            int j = end;

            System.out.println("init j " + j + " i " + i);
            // 基准值的下标
            int k = begin;

            while (i < j) {
                // 从右往左找第一个比key小的数字
                while (arr[j] >= key && i < j) {
                    j--;
                }

                // 从左往右找第一个比key大的数字
                while (arr[i] <= key && i < j) {
                    i++;
                }

                // 同时找到了i和j
                swap(arr, i, j);
            }
            swap(arr, begin, i);

            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
            System.out.println("一轮搞完了哦,结果是" + Arrays.toString(arr));
        }
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
