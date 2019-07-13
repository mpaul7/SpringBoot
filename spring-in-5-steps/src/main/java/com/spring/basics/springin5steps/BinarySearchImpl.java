package com.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	// how to telll that this a dependency for BinarySearchImpl bean?
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	
public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}


public int binarySearch(int[] numbers, int numberToSearchFor) {
		
	// implementing the Sorting Logic
	//BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
	
	int [] sortedNumbers = sortAlgorithm.sort(numbers);
		
		// Search the array
		
		return 3;
	}

}
