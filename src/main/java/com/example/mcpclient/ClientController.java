package com.example.mcpclient;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ChatClient chatClient;

    @PostMapping(value = "/askStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<String> askStream(@RequestParam String userInput) {
        return chatClient.prompt(userInput).stream().content();
    }

    @PostMapping("/ask")
    @ResponseBody
    public Mono<String> ask(@RequestParam String userInput) {
        return Mono.fromCallable(() ->
                        chatClient.prompt(userInput)
                                .call()
                                .content()
                ).subscribeOn(Schedulers.boundedElastic())
                .timeout(Duration.ofSeconds(60));
    }

}

