package com.example.user_sub_service.service;

import com.example.user_sub_service.model.Subscription;
import com.example.user_sub_service.model.SubscriptionRequest;
import com.example.user_sub_service.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRep;
    private final UserService userService;

    @Override
    public Optional<Subscription> saveSubscription(Long userId, SubscriptionRequest subRequest) {
        Optional<Subscription> result = Optional.empty();
        var findedUser = this.userService.findUserById(userId);
        if (findedUser.isPresent()) {
            try {
                Subscription subscription = Subscription.builder()
                        .subscriptionName(subRequest.serviceName())
                        .user(findedUser.get())
                        .build();
                result = Optional.of(this.subscriptionRep.save(subscription));
            } catch (Exception e) {
                log.error("Feedback save error: {}", e.getMessage());
            }
        }
        return result;
    }

    @Override
    public List<Subscription> findAllSubscriptionByUserId(Long userId) {
        return this.subscriptionRep.findSubscriptionByUserId(userId);
    }

    @Override
    public Optional<Subscription> deleteSubscriptionById(Long userId, Long subId) {
        Optional<Subscription> result = Optional.empty();
        var findedUser = this.userService.findUserById(userId);
        if (findedUser.isPresent()) {
            result = subscriptionRep.findById(subId);
            this.subscriptionRep.deleteById(subId);

        }
        return result;
    }

    public List<Map<String, Object>> getTopSubscriptions() {
        return subscriptionRep.findTop3PopularServices().stream()
                .map(result -> Map.of(
                        "serviceName", result[0],
                        "count", result[1]
                ))
                .collect(Collectors.toList());
    }

}
