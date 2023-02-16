package org.example.socialnetworkapi.repository;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

/**
 * {@link SocialNetworkPost} reactive repository for database operations
 *
 * @since 0.0.1-SNAPSHOT
 */
public interface SocialNetworkPostRepository extends R2dbcRepository<SocialNetworkPostModel, Long> {
    @Query("SELECT * FROM social_network_post ORDER BY view_count DESC LIMIT :amount")
    Flux<SocialNetworkPostModel> findTopX(Long amount);

}
