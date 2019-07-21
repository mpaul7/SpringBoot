package com.springboot.unittesting.mockingmockito.business;

import com.springboot.unittesting.mockingmockito.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	//Calculate sum without using Data Service
	public int calculateSum(int [] data){
		int sum = 0;
		for (int value: data) {
			sum += value;
		}
		return sum;
	}
	
	// Calculate sum using a Data service
	public int calculateSumUsingDataService(){
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for (int value: data) {
			sum += value;
		}
		return sum;
	}
	

}
