package com.monitoring.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoring.request.AuthCode;
import com.monitoring.response.IdToken;
import com.monitoring.response.TokenResponse;
import com.monitoring.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TokenController {

    private final AuthService  authService;

    @PostMapping("/token-request")
    public ResponseEntity<TokenResponse> getAccessToken(@RequestBody @Valid AuthCode autCode){
        System.out.println(autCode);
        TokenResponse token = authService.getToken(autCode.getCode());
        String idToken = token.getId_token();
        String[] idTokenParts = idToken.split("\\.");
        String decodedIdTokenPayload = getDecodedPayload(idTokenParts);

        ObjectMapper objectMapper = new ObjectMapper();

        IdToken idTokenPayload=null;
        try {
            // JSON verisini IdTokenPayload sınıfına dönüştürüyoruz
            idTokenPayload = objectMapper.readValue(decodedIdTokenPayload, IdToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println(idTokenPayload);

        String decodedAccessTokenPayload = getDecodedPayload(token.getAccess_token().split("\\."));
        System.out.println("Access Token Payload:"+decodedAccessTokenPayload);

        return ResponseEntity.ok(token);
    }

    private static String getDecodedPayload(String[] idTokenParts) {
        String payload = idTokenParts[1]; // Payload kısmını alıyoruz
        Base64.Decoder decoder = Base64.getUrlDecoder(); // Base64URL decoder oluştur
        String decodedPayload = new String(decoder.decode(payload)); // Çözülen JSON
        return decodedPayload;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
