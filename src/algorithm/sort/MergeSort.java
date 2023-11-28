package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序: 将数组不断的从中点分开，直到子数组长度为1。然后将相邻数组进行合并（直接操作原数组，遍历即在操作）
 * 关键点： 递归, 合并， 先处理左右元素然后处理根节点（二叉树后序）
 *
 * @author: east
 * @date: 2023/11/27
 */
public class MergeSort {
    public void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        mergeArray(array, left, mid, right);
    }


    /**
     * 将两个数组合并
     */
    public void mergeArray(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] result = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                result[k++] = array[i];
                i++;
            } else {
                result[k++] = array[j];
                j++;
            }
        }

        // 剩余的元素直接加到后面就行
        while (i <= mid) {
            result[k++] = array[i];
            i++;
        }

        // 剩余的元素直接加到后面就行，这里的逻辑和上面不会同时进行
        while (j <= right) {
            result[k++] = array[j];
            j++;
        }

        for (int ii = 0; ii < k; ii++) {
            array[left++] = result[ii];
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array11 = {5, 4, 3, 2, 1};
        int[] array2 = {10, 10, 10, 10, 10};
        int[] array3 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5};
        int[] array4 = {12, 24, 15, 26, 14, -10, 9, 16, -28, -16, 9, -6, 7, -29, 3, -6, 4, 0, 7, 0};
        int[] array5 = {2, 3, 3, 1, 5};

        int[] array = array1;
        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
