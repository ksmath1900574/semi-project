package com.example.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "FI-BO 도서관 시스템에 오신 것을 환영합니다");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    @GetMapping("/write-review")
    public String writeReview() {
        return "writeReview";
    }

    @GetMapping("/customer-support")
    public String customerSupport() {
        return "customerSupport";
    }

    @GetMapping("/kakaoBookSearch")
    public String kakaoBookSearch() {
        return "kakaoBookSearch";
    }
}
