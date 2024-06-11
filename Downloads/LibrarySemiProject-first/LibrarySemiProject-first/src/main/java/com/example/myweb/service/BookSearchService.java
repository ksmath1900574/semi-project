package com.example.myweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class BookSearchService {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    // 카카오 api를 사용하여 책을 검색하는 메소드
    public String searchBooks(String searchType, String query, int page, int size) {
        // api url
        StringBuilder apiUrl = new StringBuilder("https://dapi.kakao.com/v3/search/book?target=")
                .append(searchType)
                .append("&query=").append(query)
                .append("&page=").append(page)
                .append("&size=").append(size);

        // rest api
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoApiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // api 응답
        ResponseEntity<String> response = restTemplate.exchange(apiUrl.toString(), HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
