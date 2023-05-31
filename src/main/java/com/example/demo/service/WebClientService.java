package com.example.demo.service;

import com.example.demo.ResponseData;
import com.example.demo.domain.AccountData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public ResponseData filterAccount(){
        MultiValueMap<String, String> variables = new LinkedMultiValueMap<>();
        variables.add("id", "1");
        variables.add("username", "nguyenthai");
        Consumer<HttpHeaders> headersConsumer = new Consumer<HttpHeaders>() {
            @Override
            public void accept(HttpHeaders httpHeaders) {
                httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            }
        };
        ResponseData<AccountData> data = getAccountFromAPI("/api/account/getInfo", variables, headersConsumer);
        return data;
    }
    public ResponseData<AccountData> getAccountFromAPI(String path, MultiValueMap<String, String> data, Consumer<HttpHeaders> headersConsumer) {

        return this.webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(path)
                                .queryParams(data)
                                .build()
                ).headers(headersConsumer)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> {
                    System.out.println("4xx error");
                    return Mono.error(new RuntimeException("4xx"));
                })
                .onStatus(HttpStatus::is5xxServerError, response -> {
                    System.out.println("5xx error");
                    return Mono.error(new RuntimeException("5xx"));
                })
                .bodyToMono(ResponseData.class)
                .block();
    }
}
