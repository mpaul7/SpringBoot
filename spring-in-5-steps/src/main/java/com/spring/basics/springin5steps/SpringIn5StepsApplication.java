package com.spring.basics.springin5steps;

import java.applet.AppletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {
	
	// Now this is loosely coupled, by using SortedAlgorithm interface.
	// Spring framework can be used for Dependency Injection and IoC.
	// So what is needed to implement DI and IoC?
	// 1. What are the beans -> @Component
	// 2. Whar are the dependencies of a bean? -> @Autowired
	// 3. Where to search for beans? -> @pringBootApplication automatically does @ComponentScan.
	//    In Springboot there is no need to specifically add @ComponentScan annotation.
	//    this line of code is automatically implemented.
	//    BinarySearchImpl binarySearch  = new BinarySearchImpl(new BubbleSortAlgorithm());
	// 4. how to get the bean from springboot framework -> From Application Context.
	// All the beans are managed by ApplicationContext
	

	public static void main(String[] args) {
		
		//BinarySearchImpl binarySearch  = new BinarySearchImpl(new BubbleSortAlgorithm());
		//BinarySearchImpl binarySearch  = new BinarySearchImpl(new QuickSortAlgorithm());
		
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {12,4, 6}, 3);
		System.out.println(result);
		
	}

}
