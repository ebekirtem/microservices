package com.monitoring.controller.interview;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class ExampleController {

    @GetMapping("/{id}")
    public ResponseEntity<String> find( String id) {
        return ResponseEntity.ok().body(UUID.randomUUID().toString());
    }


    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody RequestDto requestDto){

        UUID uuid = UUID.randomUUID();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(uuid)
                .toUri();



        //call service metod
        return ResponseEntity.created(uri).body("OK");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDto {
        @NotBlank
        private String name;

        @Email
        @NotBlank
        private String email;
    }
}
