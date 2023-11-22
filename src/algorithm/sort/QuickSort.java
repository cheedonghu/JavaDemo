package algorithm.sort;

import algorithm.util.Util;

import java.util.Arrays;

/**
 * 快速排序 ：找一个基准数(最左边）array[left]，从最右开始(right)找比其小的数，再从左(left)找比其大的数，找到后交换，ij相遇则将base和ij交换。之后再以base进行
 * 分割，将分割的额外数组做同样的事
 * <p>
 * 关键点：基准数，左右指针，数组分割(需要分割依据），分治
 *
 * @author: east
 * @date: 2023/11/22
 */
public class QuickSort {

    public void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = partSort(array, left, right);

        sort(array, left, base - 1);
        sort(array, base + 1, right);
    }

    public int partSort(int[] array, int left, int right) {
        int base = array[left];
        int i = left, j = right;
        while (i < j) {
            // 必须<=有=，否则出现相等元素时，会死循环
            while (i < j && base <= array[j]) {
                j--;
            }
            while (i < j && base >= array[j]) {
                i++;
            }
            // 找到目标（这里也可能代表i=j，不过无所谓，相等时交换也没事）
            Util.swap(array, i, j);
        }
        // 基数换位，分割数组，小任务完成
        Util.swap(array, left, i);
        return i;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 3, 1, 5};

        QuickSort sort = new QuickSort();
        sort.sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
