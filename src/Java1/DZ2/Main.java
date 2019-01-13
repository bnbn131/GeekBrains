package Java1.DZ1.Java1.DZ2;



public class Main {


    static int[] replaceArrayValues(int[] array) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = (array[i] > 0) ? 0 : 1;
        }
        return array;
    }


    static int[] fillArray(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            array[i] = i * 3;
        }
        return array;
    }


    static int[] multiplyLess6(int[] array) {
        int length = array.length;
        int tmp;

        for (int i = 0; i < length; i++) {
            tmp = array[i];
            array[i] = tmp < 6 ? tmp * 2 : tmp;
        }
        return array;
    }


    static int[][] fillDiagonalArray(int[][] array) {
        int length = array.length;
        int firstItem;
        int lastItem;
        int firstArray;
        int lastArray;

        for (int i = 0; i < length; i++) {
            firstItem = i;
            lastItem = length - i - 1;

            firstArray = array[i][firstItem];
            lastArray = array[i][lastItem];

            if (firstArray != 1 && lastArray != 1) {
                array[i][firstItem] = 1;
                array[i][lastItem] = 1;
            }
        }
        return array;
    }


    static int[] minMax(int[] array) {
        int min = 0;
        int max = 0;

        for (int item : array) {
            if (item < min) min = item;
            if (item > max) max = item;
        }
        return new int[]{min, max};
    }


    static boolean checkBalance(int[] array) {
        int length = array.length;
        int leftSum;
        int rightSum;

        for (int i = 0; i < length - 1; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j <= i; j++) {
                leftSum += array[j];
            }

            for (int k = i + 1; k < length; k++) {
                rightSum += array[k];
            }

            if (leftSum == rightSum) return true;
        }
        return false;
    }


    static int[] arrayNOffset(int[] array, int n) {

        if (n < 0) {
            negativeArrayNOffset(array, n);
        } else {
            positiveArrayNOffset(array, n);
        }


        return array;
    }

    private static int[] negativeArrayNOffset(int[] array, int n) {
        int length = array.length;
        int current;
        int next;
        n *= -1;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < length - 1; k++) {
                current = array[k];
                next = k + 1;

                if (k + 1 > length - 1) {
                    next = 0;
                }
                array[k] = array[next];
                array[next] = current;
            }
        }

        return array;
    }

    private static int[] positiveArrayNOffset(int[] array, int n) {
        int length = array.length - 1;
        int current;
        int prev;

        for (int i = 0; i < n; i++) {
            for (int k = length; 0 <= k; k--) {
                current = array[k];
                prev = k - 1;

                if (k - 1 < 0) {
                    prev = 0;
                }
                array[k] = array[prev];
                array[prev] = current;
            }

        }

        return array;
    }
}
