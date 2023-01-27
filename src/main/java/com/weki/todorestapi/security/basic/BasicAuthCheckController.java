package com.weki.todorestapi.security.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthCheckController {

    @GetMapping("/basic-auth-check")
    public ResponseEntity<?> checkBasicAuth() {
        return ResponseEntity.ok().build();
    }
}
