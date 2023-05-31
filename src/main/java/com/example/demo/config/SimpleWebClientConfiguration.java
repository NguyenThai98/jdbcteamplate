package com.example.demo.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.List;
import java.util.UUID;

@Component
public class SimpleWebClientConfiguration {
    private final String BASE_URL = "http://localhost:8080";

    public SimpleWebClientConfiguration() {
    }

    private static final Logger logger = LoggerFactory.getLogger(SimpleWebClientConfiguration.class);


    @Bean
    public WebClient webClient() {

        // HttpClient configuration
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000) // millis
                .compress(true)
                .doOnConnected(connection ->
                        connection
                                .addHandlerLast(new ReadTimeoutHandler(2)) // seconds
                                .addHandlerLast(new WriteTimeoutHandler(2))); //seconds
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                //.filter(ExchangeFilterFunctions.basicAuthentication("rieckpil", UUID.randomUUID().toString()))
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            logger.info("--- Http Headers: ---");
            clientRequest.headers().forEach(this::logHeader);
            logger.info("--- Http Cookies: ---");
            clientRequest.cookies().forEach(this::logHeader);
            return next.exchange(clientRequest);
        };
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            logger.info("Response: {}", clientResponse.statusCode());
            clientResponse.headers().asHttpHeaders()
                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return Mono.just(clientResponse);
        });
    }

    private void logHeader(String name, List<String> values) {
        values.forEach(value -> logger.info("{}={}", name, value));
    }
}
