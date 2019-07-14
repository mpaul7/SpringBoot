package com.RESTFul.WebServices.restfulwebservicesbasics;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	/**
	 * @author s3409304
	 * Returning a bean
	 * This bean is automatically converted to Json response
	 * 
	 * Who does this auto convertion of a bean to a Json format
	 * - It is handled automatically by AutoConfiguration
	 * - It also configures DispatcherServlet.
	 * 
	 * 
	 */
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	/**
	 * 
	 * @param name
	 * Getting fields from URL Path
	 */
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s" , name));
	}
}
