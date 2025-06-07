package com.example.user_sub_service.controller;

import com.example.user_sub_service.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class TopSubscriptionsController {
    private final SubscriptionService subService;

    @GetMapping("/top")
    public ResponseEntity<List<Map<String, Object>>> getTopSubscriptions() {
        return ResponseEntity.ok(subService.getTopSubscriptions());
    }
}
