package com.example.myweb.controller;

import com.example.myweb.service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSearchController {

    @Autowired
    private BookSearchService bookSearchService;

    //api를 사용해 책 검색하는 메소드
    @GetMapping("/api/searchBooks")
    public String searchBooks(@RequestParam String searchType, 
                              @RequestParam String query, 
                              @RequestParam int page, @RequestParam int size) {
        return bookSearchService.searchBooks(searchType, query, page, size);
    }
}
