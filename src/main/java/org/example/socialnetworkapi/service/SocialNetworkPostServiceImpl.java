package org.example.socialnetworkapi.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.mapper.SocialNetworkPostMapper;
import org.example.socialnetworkapi.repository.SocialNetworkPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class SocialNetworkPostServiceImpl implements SocialNetworkPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialNetworkPostServiceImpl.class);

    private final SocialNetworkPostRepository postRepository;

    public SocialNetworkPostServiceImpl(SocialNetworkPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("SocialNetworkPostServiceImpl has been initialized.");
    }

    @PreDestroy
    public void tearDown() {
        LOGGER.info("SocialNetworkPostServiceImpl has been terminated.");
    }

    @Override
    public Flux<SocialNetworkPost> findAll() {
        return postRepository.findAll().map(SocialNetworkPostMapper::toApi);
    }

    @Override
    public Mono<SocialNetworkPost> findById(Long id) {
        return postRepository.findById(id).map(SocialNetworkPostMapper::toApi);
    }

    @Override
    public Flux<SocialNetworkPost> findTopX(Long amount) {
        return postRepository.findTopX(amount).map(SocialNetworkPostMapper::toApi);
    }

    @Override
    public Mono<SocialNetworkPost> save(Mono<SocialNetworkPost> post) {
        return post.flatMap(p -> postRepository.save(SocialNetworkPostMapper.toModel(p))
                .map(SocialNetworkPostMapper::toApi));
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id).subscribe();
    }

    @Override
    public void deleteAll() {
        postRepository.deleteAll().subscribe();
    }

}
