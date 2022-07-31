/**
 * Sorter contains common algorithmic sorting methods for a sequence of numbers.
 * References ch. 2 of Introduction to Algorithms by Cormen, Leiserson, et al.
 *
 * @author Vaishakh Kallattil
 */
public class Sorter {
    /**
     * Implements Insertion Sort to sort a given unsorted integer array with at least
     * two elements. If the array contains less than two elements, the array is either
     * empty or already sorted (one element), so the method returns.
     *
     * @param array an unsorted integer array
     */
    public static void insertionSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    /**
     * Implements Merge Sort to sort a given unsorted integer array. Divides array
     * into two subarrays of array.length / 2, and calls itself recursively on both
     * subarrays. Once the two subarrays are sorted recursively, calls the merge
     * subroutine on both subarrays.
     *
     * @param array an unsorted integer array
     * @param p the first index of the array to be sorted
     */
    public static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    /**
     * Implements the Merge subroutine, called by Merge Sort. Takes an unsorted integer
     * array that contains two sorted subarrays, and does an element by element comparison
     * with both subarrays and merges them to create a combined sorted array.
     *
     * @param array an unsorted integer array
     * @param p the index of the first element of the first sorted subarray
     * @param q the index of the last element of the first sorted subarray
     * @param r the index of the last element of the second sorted subarray. q + 1
     * indicates the index of the first element of the second sorted subarray.
     */
    static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = array[p + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = array[q + j + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }
    }
}
