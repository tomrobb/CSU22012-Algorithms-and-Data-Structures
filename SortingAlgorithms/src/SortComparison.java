import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Tom Roberts
 * @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		int N = a.length;
		for (int i = 0; i < N; i++) {

			double temp = a[i];
			int j = i;

			while (j > 0 && a[j - 1] > temp) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}

		// TODO: implement the sort
		return a;

	}// end insertion sort

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {

		// TODO: implement the sort
		int n = a.length;

		// one by one, move the boundary of the unsorted array
		for (int i = 0; i < n; i++) {

			// find the minimum element in the unsorted array
			int min_idx = i;

			for (int j = i + 1; j < n; j++) {

				if (a[j] < a[min_idx])
					min_idx = j;
			}

			// swap the found element, with the first element
			double temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}

		return a;
	}// end selection sort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {

		// TODO: implement the sort
		int lo = 0;
		int hi = a.length - 1;

		quickSortR(a, lo, hi);
		return a;

	}// end quickSort

	/*
	 * This method implements quickSort recursively, for a given array of doubles.
	 * 
	 * @param a: unsorted array, of type double
	 * 
	 * @param lo: low index
	 * 
	 * @param hi: high index
	 */
	private static void quickSortR(double a[], int lo, int hi) {

		if (lo >= hi)
			return;

		// finding the pivot value
		int middle = lo + (hi - lo) / 2;
		double pivot = a[middle];

		// sort the values less than the pivot to the left.
		// and the values greater than the pivot to the right.
		int i = lo;
		int j = hi;

		while (i <= j) {

			// find low value !< pivot
			while (a[i] < pivot) {
				i++;
			}

			// find low value !< pivot
			while (a[j] > pivot) {
				j--;
			}

			if (i <= j) {
				double temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		// Recursively quickSort two sub parts
		if (lo < j)
			quickSortR(a, lo, j);

		if (hi > i)
			quickSortR(a, i, hi);

	}

	/*
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * 
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSort(double a[]) {

		double temp[] = new double[a.length];

		mergeSortR(a, temp, 0, a.length - 1);
		return a;

	}// end mergeSort

	/*
	 * This method implements mergeSort recursively, for a given array of doubles.
	 * within the given indices high and low.
	 * 
	 * @param a: unsorted array, of type double
	 * 
	 * @param temp: a temporary array to be used in the mergeSort
	 * 
	 * @param lo: low index
	 * 
	 * @param hi: high index
	 */

	private static void mergeSortR(double a[], double temp[], int lo, int hi) {

		if (lo < hi) {

			int middle = (lo + hi) / 2;
			mergeSortR(a, temp, lo, middle);
			mergeSortR(a, temp, middle + 1, hi);
			merge(a, temp, lo, middle + 1, hi);

		}
	}

	/*
	 * This method combines mergeSort's into one larger array
	 * 
	 * @param a: unsorted array, of type double
	 * 
	 * @param temp: a temporary array to be used in the mergeSort
	 * 
	 * @param lo: index of lower element
	 * 
	 * @param mid: index of middle element
	 * 
	 * @param hi: index of higher element
	 */

	private static void merge(double a[], double temp[], int left, int right, int rightEnd) {
		
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			
			if (a[left] <= a[right])
				temp[k++] = a[left++];
			else
				temp[k++] = a[right++];
		}

		while (left <= leftEnd) {
			// copy the rest of the first half
			temp[k++] = a[left++];
		}

		
		while (right <= rightEnd) {
			// copy the rest of the right half
			temp[k++] = a[right++];
		}

		// copy the temporary array back
		for (int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = temp[rightEnd];
		}
		
	}
	
	


}// end class
