package org.example.socialnetworkapi.service;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive base interface for {@link SocialNetworkPost} operations
 *
 * @since 0.0.1-SNAPSHOT
 */
public interface SocialNetworkPostService {

    Flux<SocialNetworkPost> findAll();
    Mono<SocialNetworkPost> findById(Long id);
    Flux<SocialNetworkPost> findTopX(Long amount);
    void save(Mono<SocialNetworkPost> post);
    void deleteById(Long id);

}
