package org.example.socialnetworkapi.config;

import jakarta.annotation.PreDestroy;
import org.example.socialnetworkapi.repository.SocialNetworkPostRepository;
import org.example.socialnetworkapi.service.SocialNetworkPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order
@Component
public class TearDownService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TearDownService.class);

    private final SocialNetworkPostService postService;

    public TearDownService(SocialNetworkPostService postService) {
        this.postService = postService;
    }

    @PreDestroy
    public void cleanupPostRepository() {
        postService.deleteAll();
        LOGGER.info("SocialNetworkPost repository was cleared. TearDownService has been terminated.");
    }

}
