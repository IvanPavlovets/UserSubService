package com.example.user_sub_service.repository;

import com.example.user_sub_service.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findSubscriptionByUserId(Long userId);

    @Query("SELECT s.subscriptionName, COUNT(s) as count FROM Subscription s GROUP BY s.subscriptionName ORDER BY count DESC LIMIT 3")
    List<Object[]> findTop3PopularServices();
}
