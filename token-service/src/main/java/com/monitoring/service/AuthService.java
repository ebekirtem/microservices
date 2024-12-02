package com.monitoring.service;

import com.monitoring.response.TokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthService {

    private final WebClient webClient;

    public AuthService(WebClient.Builder webClientBuilder) {
        // Keycloak’ın base URL'sini tanımlıyoruz
        this.webClient = webClientBuilder.baseUrl("http://localhost:8084/realms/ebut").build();
    }

    public TokenResponse getToken(String authorizationCode) {
//        TokenResponse response = webClient.post()
//                .uri("/protocol/openid-connect/token") // Token endpoint yolu
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .body(BodyInserters.fromFormData("grant_type", "authorization_code")
//                        .with("code", authorizationCode)
//                        .with("redirect_uri", "http://localhost:3000/callback")
//                        .with("client_id", "ebut-client")
//                        .with("client_secret", "Yhq6BRJSGXbwcYITxoffjr81ga0YvLGE"))
//                .retrieve()
//                .bodyToMono(TokenResponse.class)
//                .block();// Senkronize olarak yanıt almak için block() kullanılır
//        return response;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("code", authorizationCode); // frontend'den gelen code
        params.add("redirect_uri", "http://localhost:3000/callback");
        params.add("client_id", "ebut-client");
        params.add("client_secret", "Yhq6BRJSGXbwcYITxoffjr81ga0YvLGE");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity("http://localhost:8084/realms/ebut/protocol/openid-connect/token", request, TokenResponse.class);

      return  response.getBody();
    }
}
