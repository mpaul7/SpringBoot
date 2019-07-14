package com.springbootbasics.springbootin10steps;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BooksController {
	
@GetMapping("/books")
public List<Book> getAllBooks(){
	return Arrays.asList(new Book (1L, "Mastering Spring Boot", "MPaul"));
}
}
