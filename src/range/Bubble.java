package range;


import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 每一轮排序，都会将最大的数移动到队尾
 * <p>
 * 这样下一轮就只需要对n-1个数进行比较
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {12, 5, 16, 4223, 54, 657, 32, 188, 97, 6};
        bubble(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }


    public static void bubble(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                // 一轮这么两两对比之后，最大的数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("一次：" + Arrays.toString(arr));
        }

    }


}
