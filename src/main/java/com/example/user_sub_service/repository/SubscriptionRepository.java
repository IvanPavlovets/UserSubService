package com.example.user_sub_service.repository;

import com.example.user_sub_service.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findSubscriptionByUserId(Long userId);
}
