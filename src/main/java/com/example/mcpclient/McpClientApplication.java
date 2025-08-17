package com.example.mcpclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpClientApplication.class, args);
    }

    @Bean
    public ChatClient predefinedQuestions(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools) {
        return chatClientBuilder
                .defaultToolCallbacks(tools)
                .build();

    }

}
