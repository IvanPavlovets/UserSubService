package com.example.user_sub_service.service;

import com.example.user_sub_service.model.Subscription;
import com.example.user_sub_service.model.SubscriptionRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SubscriptionService {
    Optional<Subscription> saveSubscription(Long userId, SubscriptionRequest subs);

    List<Subscription> findAllSubscriptionByUserId(Long userId);

    Optional<Subscription> deleteSubscriptionById(Long userId, Long subId);

    List<Map<String, Object>> getTopSubscriptions();
}
