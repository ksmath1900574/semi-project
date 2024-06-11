package com.example.myweb.controller;

import com.example.myweb.model.Book;
import com.example.myweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 책 검색 페이지로 이동
    @GetMapping("/search")
    public String searchBooks(@RequestParam(required = false) String keyword, 
                              @RequestParam(required = false) String searchType, 
                              Model model) {
        if (keyword != null && searchType != null) {
            List<Book> books;
            // 검색 유형에 따라 책을 검색
            if ("title".equals(searchType)) {
                books = bookService.searchBooksByTitle(keyword);
            } else if ("author".equals(searchType)) {
                books = bookService.searchBooksByAuthor(keyword);
            } else {
                books = bookService.searchBooks(keyword);
            }
            model.addAttribute("books", books);
            model.addAttribute("keyword", keyword);
            model.addAttribute("resultCount", books.size());
        }
        return "bookSearch";
    }


    // 검색 폼 페이지로 이동
    @GetMapping("/search-form")
    public String searchForm() {
        return "bookSearch";
    }
}
