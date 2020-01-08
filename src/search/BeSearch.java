package search;

/**
 * 二分查找最大的问题在于向下取整还是向上取整，因为对于int类型，语言一般默认向下取整
 */
public class BeSearch {

    public static void main(String[] args) {

        // +1 -1 /2 主要是在细节上的差别，及对于奇数/偶数个 的区别是向上取整还是向下取整
        int[] array = {1, 4, 11, 23, 45, 64, 79, 109, 112};

        int beSearch = beSearch2(array, 0, 7, 112);

        System.out.println("besearch is " + beSearch);
    }

    // 二分查找算法
    public static int beSearch(int[] array, int low, int high, int target) {
        int mid = low + (high - low) / 2;

        System.out.println("search value is " + array[mid]);
        if (target > array[mid]) {
            return beSearch(array, mid + 1, high, target);
        } else if (target < array[mid]) {
            return beSearch(array, low, mid - 1, target);
        }
        System.out.println("finial serach  " + array[mid]);
        return array[mid];
    }

    public static int beSearch1(int[] array, int low, int high, int target) {
        int mid = low + (high - low) / 2;
        while (high >= low) {
            System.out.println("search value is " + array[mid]);
            if (array[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        System.out.println("low " + low + " high " + high);
        return array[mid];
    }

    public static int beSearch2(int[] array, int low, int high, int target) {
        int middle = low + (high - low + 1) / 2;
        while (low < high) {
            System.out.println("search value is " + array[middle]);
            if (array[middle] >= target) {
                high = middle - 1;
            } else {
                low = middle;
            }
            middle = low + (high - low + 1) / 2;
        }
        return array[middle];
    }
}
