import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Tom Roberts
 *  @version HT 2020
 *  
 *  
 *  The following values are the averages of each respective algorithm, while using the supplied text files as inputs
 *  
 *  time (ns)				-	insertionSort	-	selectionSort	-	quickSort		-	mergeSort		-
 *  ---------------------------------------------------------------------------------------------------------
 *  1000 random				-	859,366			-	2,048,433		-	137,233			-	194,666			-
 *  1000 duplicates			-	509,833			-	1,813,300		-	40,366			-	73,866			-			
 *  1000 nearly ordered		-	102,666			-	204,200			-	25,266			-	70,400			-
 *  1000 reverse			-	420,066			-	202,666			-	24,166			-	68,866			-
 *  1000 sorted				-	4,933			-	211,000			-	24,233			-	68,500			-
 *  10000 random			-	19,822,300		-	15,701,066		-	321,066			-	882,400			-
 *  
 *  
 *  
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    
    
    @Test
    public void testEmpty()
    {
    	
    	double a[] = {};
    	double actualReturn[] = new double[a.length];
    	int length;
    	
    	actualReturn = SortComparison.insertionSort(a);
    	length = actualReturn.length;
    	assertEquals("Checking insertionSort on an empty array, returned array should also be empty", length, 0);
    	
    	actualReturn = SortComparison.selectionSort(a);
    	length = actualReturn.length;
    	assertEquals("Checking selectionSort on an empty array, returned array should also be empty", length, 0);
    	
    	actualReturn = SortComparison.quickSort(a);
    	length = actualReturn.length;
    	assertEquals("Checking quickSort on an empty array, returned array should also be empty", length, 0);
    	
    	actualReturn = SortComparison.mergeSort(a);
    	length = actualReturn.length;
    	assertEquals("Checking mergeSort on an empty array, returned array should also be empty", length, 0);
    	
    	
    	
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    
    @Test
    public void testInsertionSort()
    {
    	// testing on an array of random order, with random variables -200 - 1500
    	double a[] = {1054.0, 181.0, 897.0, 316.0, 577.0, -15.0, 1198.0, 476.0, 1098.0, -80.0, 165.0, 814.0};
    	double expectedReturn[] = {-80.0, -15.0, 165.0, 181.0, 316.0, 476.0, 577.0, 814.0, 897.0, 1054.0, 1098.0, 1198.0};
    	double actualReturn[] = new double[a.length];
    	
    	actualReturn = SortComparison.insertionSort(a);
    	assertArrayEquals("Checking insertionSort on a test array, actualReturn should equal expectedReturn", expectedReturn, actualReturn, 0);
    	
    	// testing on an array of 1 element
    	double b[] = {808.0};
    	double expectedReturn2[] = {808.0};
    	double actualReturn2[] = new double[b.length];
    	
    	actualReturn2 = SortComparison.insertionSort(b);
    	assertArrayEquals("Checking insertionSort on an empty array, actualReturn should equal expectedReturn", expectedReturn2, actualReturn2, 0);
    	
    	// testing on an array of 2 elements
    	double c[] = {739.0, 594.0};
    	double expectedReturn3[] = {594.0, 739.0};
    	double actualReturn3[] = new double[c.length];
    	
    	actualReturn3 = SortComparison.insertionSort(c);
    	assertArrayEquals("Checking insertionSort on an array of 2 elements, actualReturn should equal expectedReturn", expectedReturn3, actualReturn3, 0);
    	
    	//testing on an array of 3 elements
    	double d[] = {-72.0, 1251.0, 749.0};
    	double expectedReturn4[] = {-72.0, 749.0, 1251.0};
    	double actualReturn4[] = new double[d.length];
    	
    	actualReturn4 =  SortComparison.insertionSort(d);
    	assertArrayEquals("Checking insertionSort on an array of 3 elements, actualReturn should equal expectedReturn", expectedReturn4, actualReturn4, 0);
    			
    	
    }
    
    
    
    @Test
    public void testSelectionSort() {
    	
    	// testing on an array of random order, with random variables -200 - 1500
    	double a[] = {1054.0, 181.0, 897.0, 316.0, 577.0, -15.0, 1198.0, 476.0, 1098.0, -80.0, 165.0, 814.0};
    	double expectedReturn[] = {-80.0, -15.0, 165.0, 181.0, 316.0, 476.0, 577.0, 814.0, 897.0, 1054.0, 1098.0, 1198.0};
    	double actualReturn[] = new double[a.length];
    	
    	actualReturn = SortComparison.selectionSort(a);
    	assertArrayEquals("Checking selectionSort on a test array, actualReturn should equal expectedReturn", expectedReturn, actualReturn, 0);
    	
    	// testing on an array of 1 element
    	double b[] = {808.0};
    	double expectedReturn2[] = {808.0};
    	double actualReturn2[] = new double[b.length];
    	
    	actualReturn2 = SortComparison.selectionSort(b);
    	assertArrayEquals("Checking selectionSort on an empty array, actualReturn should equal expectedReturn", expectedReturn2, actualReturn2, 0);
    	
    	// testing on an array of 2 elements
    	double c[] = {739.0, 594.0};
    	double expectedReturn3[] = {594.0, 739.0};
    	double actualReturn3[] = new double[c.length];
    	
    	actualReturn3 = SortComparison.selectionSort(c);
    	assertArrayEquals("Checking selectionSort on an array of 2 elements, actualReturn should equal expectedReturn", expectedReturn3, actualReturn3, 0);
    	
    	//testing on an array of 3 elements
    	double d[] = {-72.0, 1251.0, 749.0};
    	double expectedReturn4[] = {-72.0, 749.0, 1251.0};
    	double actualReturn4[] = new double[d.length];
    	
    	actualReturn4 =  SortComparison.selectionSort(d);
    	assertArrayEquals("Checking selectionSort on an array of 3 elements, actualReturn should equal expectedReturn", expectedReturn4, actualReturn4, 0);
    	
    }
    
    
    @Test
    public void testQuickSort() {
    	
    	// testing on an array of random order, with random variables -200 - 1500
    	double a[] = {1054.0, 181.0, 897.0, 316.0, 577.0, -15.0, 1198.0, 476.0, 1098.0, -80.0, 165.0, 814.0};
    	double expectedReturn[] = {-80.0, -15.0, 165.0, 181.0, 316.0, 476.0, 577.0, 814.0, 897.0, 1054.0, 1098.0, 1198.0};
    	double actualReturn[] = new double[a.length];
    	
    	actualReturn = SortComparison.quickSort(a);
    	assertArrayEquals("Checking quickSort on a test array, actualReturn should equal expectedReturn", expectedReturn, actualReturn, 0);
    	
    	// testing on an array of 1 element
    	double b[] = {808.0};
    	double expectedReturn2[] = {808.0};
    	double actualReturn2[] = new double[b.length];
    	
    	actualReturn2 = SortComparison.quickSort(b);
    	assertArrayEquals("Checking quickSort on an empty array, actualReturn should equal expectedReturn", expectedReturn2, actualReturn2, 0);
    	
    	// testing on an array of 2 elements
    	double c[] = {739.0, 594.0};
    	double expectedReturn3[] = {594.0, 739.0};
    	double actualReturn3[] = new double[c.length];
    	
    	actualReturn3 = SortComparison.quickSort(c);
    	assertArrayEquals("Checking quickSort on an array of 2 elements, actualReturn should equal expectedReturn", expectedReturn3, actualReturn3, 0);
    	
    	//testing on an array of 3 elements
    	double d[] = {-72.0, 1251.0, 749.0};
    	double expectedReturn4[] = {-72.0, 749.0, 1251.0};
    	double actualReturn4[] = new double[d.length];
    	
    	actualReturn4 =  SortComparison.quickSort(d);
    	assertArrayEquals("Checking quickSort on an array of 3 elements, actualReturn should equal expectedReturn", expectedReturn4, actualReturn4, 0);
    
    }
    
    
    
    @Test
    public void testMergeSort() {
    	
    	// testing on an array of random order, with random variables -200 - 1500
    	double a[] = {1054.0, 181.0, 897.0, 316.0, 577.0, -15.0, 1198.0, 476.0, 1098.0, -80.0, 165.0, 814.0};
    	double expectedReturn[] = {-80.0, -15.0, 165.0, 181.0, 316.0, 476.0, 577.0, 814.0, 897.0, 1054.0, 1098.0, 1198.0};
    	double actualReturn[] = new double[a.length];
    	
    	actualReturn = SortComparison.mergeSort(a);
    	assertArrayEquals("Checking mergeSort on a test array, actualReturn should equal expectedReturn", expectedReturn, actualReturn, 0);
    	
    	// testing on an array of 1 element
    	double b[] = {808.0};
    	double expectedReturn2[] = {808.0};
    	double actualReturn2[] = new double[b.length];
    	
    	actualReturn2 = SortComparison.mergeSort(b);
    	assertArrayEquals("Checking mergeSort on an empty array, actualReturn should equal expectedReturn", expectedReturn2, actualReturn2, 0);
    	
    	// testing on an array of 2 elements
    	double c[] = {739.0, 594.0};
    	double expectedReturn3[] = {594.0, 739.0};
    	double actualReturn3[] = new double[c.length];
    	
    	actualReturn3 = SortComparison.mergeSort(c);
    	assertArrayEquals("Checking mergeSort on an array of 2 elements, actualReturn should equal expectedReturn", expectedReturn3, actualReturn3, 0);
    	
    	//testing on an array of 3 elements
    	double d[] = {-72.0, 1251.0, 749.0};
    	double expectedReturn4[] = {-72.0, 749.0, 1251.0};
    	double actualReturn4[] = new double[d.length];
    	
    	actualReturn4 =  SortComparison.mergeSort(d);
    	assertArrayEquals("Checking mergeSort on an array of 3 elements, actualReturn should equal expectedReturn", expectedReturn4, actualReturn4, 0);
    
    }
    
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    
	public static double[] fillArray(File file, int n) throws FileNotFoundException {
		
		double[] outputArray = new double[n];
		Scanner in = new Scanner(file);
		
		for(int i=0; i < outputArray.length; i++){
			outputArray[i] = in.nextDouble();
		}
		
		in.close();
		return outputArray;
	}
	
	public static long insertionSortTimer(double[] a) {
		
		long start, end, performance;
    	long total = 0;
    	
    	// run the experiment 3 times, and get the average
    	for(int i=0; i<3; i++) {
    		//create a duplicate of the array, since it's in-place
    		double[] x = new double[a.length];
    		System.arraycopy(a, 0, x, 0, a.length);
    		
    		// start the clock
    		start = 0;
    		start = System.nanoTime();
    		
    		x = SortComparison.insertionSort(a);
    		
    		// end the clock
    		end = 0;
    		end = System.nanoTime();
    		
    		performance = end - start;
    		
    		total += performance;
    	}
		// get the average
    	total = total /3;
    	return total;
	}
	
	
	
	public static long selectionSortTimer(double[] a) {
		
		long start, end, performance;
    	long total = 0;
    	
    	// run the experiment 3 times, and get the average
    	for(int i=0; i<3; i++) {
    		//create a duplicate of the array, since it's in-place
    		double[] x = new double[a.length];
    		System.arraycopy(a, 0, x, 0, a.length);
    		
    		// start the clock
    		start = 0;
    		start = System.nanoTime();
    		
    		x = SortComparison.selectionSort(a);
    		
    		// end the clock
    		end = 0;
    		end = System.nanoTime();
    		
    		performance = end - start;
    		
    		total += performance;
    	}
		// get the average
    	total = total /3;
    	return total;
	}
	
	
	public static long quickSortTimer(double[] a) {
		
		long start, end, performance;
    	long total = 0;
    	
    	// run the experiment 3 times, and get the average
    	for(int i=0; i<3; i++) {
    		//create a duplicate of the array, since it's in-place
    		double[] x = new double[a.length];
    		System.arraycopy(a, 0, x, 0, a.length);
    		
    		// start the clock
    		start = 0;
    		start = System.nanoTime();
    		
    		x = SortComparison.quickSort(a);
    		
    		// end the clock
    		end = 0;
    		end = System.nanoTime();
    		
    		performance = end - start;
    		
    		total += performance;
    	}
		// get the average
    	total = total /3;
    	return total;
	}
	
	public static long mergeSortTimer(double[] a) {
		
		long start, end, performance;
    	long total = 0;
    	
    	// run the experiment 3 times, and get the average
    	for(int i=0; i<3; i++) {
    		//create a duplicate of the array, since it's in-place
    		double[] x = new double[a.length];
    		System.arraycopy(a, 0, x, 0, a.length);
    		
    		// start the clock
    		start = 0;
    		start = System.nanoTime();
    		
    		x = SortComparison.mergeSort(a);
    		
    		// end the clock
    		end = 0;
    		end = System.nanoTime();
    		
    		performance = end - start;
    		
    		total += performance;
    	}
		// get the average
    	total = total /3;
    	return total;
	}
    
    public static void main(String[] args) throws FileNotFoundException
    {
        //TODO: implement this method
    	File thousandNumbers = new File("numbers1000.txt");
    	double[] numbers1000 = fillArray(thousandNumbers, 1000);
    	
    	File thousandNumberDuplicates = new File("numbers1000Duplicates.txt");
    	double[] numbers1000Duplicates = fillArray(thousandNumberDuplicates, 1000);
    	
    	File thousandNearlyOrderedNumbers = new File("numbersNearlyOrdered1000.txt");
    	double[] numbersNearlyOrdered1000 = fillArray(thousandNearlyOrderedNumbers, 1000);
    	
    	File thousandReverseNumbers = new File("numbersReverse1000.txt");
    	double[] numbersReverse1000 = fillArray(thousandReverseNumbers, 1000);
    	
    	File thousandSortedNumbers = new File("numbersSorted1000.txt");
    	double[] numbersSorted1000 = fillArray(thousandSortedNumbers, 1000);
    	
    	File tenThousandNumbers = new File("Numbers10000.txt");
    	double[] numbers10000 = fillArray(tenThousandNumbers, 10000);
    	
    	
    	String a = "Insertion Sort";
    	String b = "Selection Sort";
    	String c = "Quick Sort";
    	String d = "Merge Sort";
    	
    	System.out.println("Average time for " + a + " with numbers1000.txt = " + insertionSortTimer(numbers1000) + " ns");
    	System.out.println("Average time for " + a + " with numbers1000Duplicates.txt = " + insertionSortTimer(numbers1000Duplicates) + " ns");
    	System.out.println("Average time for " + a + " with numbersNearlyOrdered1000.txt = " + insertionSortTimer(numbersNearlyOrdered1000) + " ns");
    	System.out.println("Average time for " + a + " with numbersReverse1000.txt = " + insertionSortTimer(numbersReverse1000) + " ns");
    	System.out.println("Average time for " + a + " with numbersSorted1000.txt = " + insertionSortTimer(numbersSorted1000) + " ns");
    	System.out.println("Average time for " + a + " with Numbers10000.txt = " + insertionSortTimer(numbers10000) + " ns");
    	
    	
    	System.out.println("\n\nAverage time for " + b + " with numbers1000.txt = " + selectionSortTimer(numbers1000) + " ns");
    	System.out.println("Average time for " + b + " with numbers1000Duplicates.txt = " + selectionSortTimer(numbers1000Duplicates) + " ns");
    	System.out.println("Average time for " + b + " with numbersNearlyOrdered1000.txt = " + selectionSortTimer(numbersNearlyOrdered1000) + " ns");
    	System.out.println("Average time for " + b + " with numbersReverse1000.txt = " + selectionSortTimer(numbersReverse1000) + " ns");
    	System.out.println("Average time for " + b + " with numbersSorted1000.txt = " + selectionSortTimer(numbersSorted1000) + " ns");
    	System.out.println("Average time for " + b + " with Numbers10000.txt = " + selectionSortTimer(numbers10000) + " ns");
    	
    	System.out.println("\n\nAverage time for " + c + " with numbers1000.txt = " + quickSortTimer(numbers1000) + " ns");
    	System.out.println("Average time for " + c + " with numbers1000Duplicates.txt = " + quickSortTimer(numbers1000Duplicates) + " ns");
    	System.out.println("Average time for " + c + " with numbersNearlyOrdered1000.txt = " + quickSortTimer(numbersNearlyOrdered1000) + " ns");
    	System.out.println("Average time for " + c + " with numbersReverse1000.txt = " + quickSortTimer(numbersReverse1000) + " ns");
    	System.out.println("Average time for " + c + " with numbersSorted1000.txt = " + quickSortTimer(numbersSorted1000) + " ns");
    	System.out.println("Average time for " + c + " with Numbers10000.txt = " + quickSortTimer(numbers10000) + " ns");
    	
    	System.out.println("\n\nAverage time for " + d + " with numbers1000.txt = " + mergeSortTimer(numbers1000) + " ns");
    	System.out.println("Average time for " + d + " with numbers1000Duplicates.txt = " + mergeSortTimer(numbers1000Duplicates) + " ns");
    	System.out.println("Average time for " + d + " with numbersNearlyOrdered1000.txt = " + mergeSortTimer(numbersNearlyOrdered1000) + " ns");
    	System.out.println("Average time for " + d + " with numbersReverse1000.txt = " + mergeSortTimer(numbersReverse1000) + " ns");
    	System.out.println("Average time for " + d + " with numbersSorted1000.txt = " + mergeSortTimer(numbersSorted1000) + " ns");
    	System.out.println("Average time for " + d + " with Numbers10000.txt = " + mergeSortTimer(numbers10000) + " ns");
    	
    	
    	
    	
    }

}
