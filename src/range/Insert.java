package range;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 主要思想是先通过和target值比较互相交换，当比较到最后一个数满足<target之后退出一轮循环
 * <p>
 * 并插入在其index+1处
 * <p>
 * 每遍一轮，下一轮比较的开始位置+1,因为前面插入了1项数据到已经排列好的那部分数组里
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = {12, 5, 4223, 54, 16, 657, 32, 188, 97, 6};
        insert1(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // i-1之前是排列好的
            int prevIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[prevIndex]) {
                    int temp = arr[prevIndex];
                    arr[prevIndex] = arr[j];
                    arr[j] = temp;
                    prevIndex = j;
                }
            }
            System.out.println("蛋汤：" + Arrays.toString(arr));
        }
    }

    public static void insert1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 前一个下标index
            int prevIndex = i - 1;
            int currentValue = arr[i];
            // 这里循环比较到比它<1的数字，只移动位置，不插入这个数据
            while (prevIndex >= 0 && arr[prevIndex] > currentValue) {
                // 不断地交换
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }
            // 一轮移动结束后，插入到该位置上
            arr[prevIndex + 1] = currentValue;

        }
    }
}
