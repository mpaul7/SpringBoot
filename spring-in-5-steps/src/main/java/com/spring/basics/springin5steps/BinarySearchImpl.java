package com.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	// how to tell that this a dependency for BinarySearchImpl bean? -> @Autowired

	@Autowired
	private SortAlgorithm sortAlgorithm;

	/**
	 * @param args 
	 * This is DI using Constructor
	 */

	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	/**
	 * This is DI using Setter Injection. It is a default method. So if
	 *  we remove code for Constructor and Setter injection code, By
	 *  default springboot will consider constructor injection.
	 */

	/*
	 * public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
	 * this.sortAlgorithm = sortAlgorithm; }
	 */
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		// implementing the Sorting Logic
		// BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

		int[] sortedNumbers = sortAlgorithm.sort(numbers);

		// Search the array

		return 3;
	}

}
