package algorithm.util;

import model.special.exception.BaseException;

/**
 * @author: east
 * @date: 2023/11/22
 */
public class Util {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static Integer findIndex(int[] array, Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        throw new BaseException();
    }
}
