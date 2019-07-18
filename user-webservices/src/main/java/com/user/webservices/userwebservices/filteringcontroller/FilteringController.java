package com.user.webservices.userwebservices.filteringcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("Value1", "value2", "value3");
	}
	
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("Value1", "value2", "value3"), 
				new SomeBean("Value11", "value12", "value13"));
	}
	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrievedynaimicFilteringSomeBean() {
		SomeDynamicBean someDynamicBean = new SomeDynamicBean("Value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");
		// to to dynamic filtering
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue filteredBean= new MappingJacksonValue(someDynamicBean);
		filteredBean.setFilters(filters);
		return filteredBean;
	}

}
