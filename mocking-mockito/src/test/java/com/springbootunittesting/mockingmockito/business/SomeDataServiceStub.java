package com.springbootunittesting.mockingmockito.business;

import com.springboot.unittesting.mockingmockito.data.SomeDataService;

//Create a stub for SomeDataService
public class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}

}
