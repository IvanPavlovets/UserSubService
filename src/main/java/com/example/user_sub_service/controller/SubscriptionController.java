package com.example.user_sub_service.controller;

import com.example.user_sub_service.model.Subscription;
import com.example.user_sub_service.model.SubscriptionRequest;
import com.example.user_sub_service.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subService;

    @PostMapping("/")
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long userId, @RequestBody SubscriptionRequest request) {
        return getResponseEntity(this.subService.saveSubscription(userId, request), HttpStatus.CREATED, HttpStatus.CONFLICT);
    }

    @GetMapping("/")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable Long userId) {
        var findedList = this.subService.findAllSubscriptionByUserId(userId);
        return new ResponseEntity<>(findedList, HttpStatus.OK);
    }

    @DeleteMapping("/{subId}")
    public ResponseEntity<Subscription> deleteSubscription(@PathVariable Long userId, @PathVariable Long subId) {
        return getResponseEntity(this.subService.deleteSubscriptionById(userId, subId), HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Subscription> getResponseEntity(Optional<Subscription> subscription, HttpStatus ok, HttpStatus notFound) {
        return new ResponseEntity<>(
                subscription.orElse(new Subscription()),
                subscription.isPresent() ? ok : notFound
        );
    }

}
