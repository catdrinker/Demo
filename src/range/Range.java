package range;

import java.util.Arrays;

public class Range {

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 52, 12};
        merge(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

    /**
     * 归并排序
     * <p>
     * 每趟归并排序的时间复杂度是O(n)
     * <p>
     * 归并的时间复杂度是O(nlgn)
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void merge(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            mergeSort(arr, left, mid, right);
        }
    }

    public static void mergeSort(int[] arr, int left, int mid, int right) {
        System.out.println("merge sort left " + left + " mid " + mid + " right " + right);
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 跳出上边循环说明至少有一边是满进了新的temp数组

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[left + i1] = temp[i1];
        }

    }

}
