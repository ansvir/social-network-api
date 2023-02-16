package org.example.socialnetworkapi.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.service.SocialNetworkPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * {@link SocialNetworkPost} REST reactive controller.
 *
 * @since 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/rest/v1/post")
public class SocialNetworkPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialNetworkPostController.class);

    private final SocialNetworkPostService postService;

    public SocialNetworkPostController(SocialNetworkPostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("SocialNetworkPostController has been initialized.");
    }

    @PreDestroy
    public void tearDown() {
        LOGGER.info("SocialNetworkPostController has been terminated.");
    }

    @GetMapping
    public Flux<SocialNetworkPost> getAll() {
        return postService.findAll();
    }

    @PostMapping
    public void createOrUpdate(@RequestBody Mono<SocialNetworkPost> post) {
        postService.save(post);
    }

    @GetMapping("/{id}")
    public Mono<SocialNetworkPost> getById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        postService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        postService.deleteAll();
    }

    @GetMapping("/top/{amount}")
    public Flux<SocialNetworkPost> getTopX(@PathVariable("amount") Long amount) {
        return postService.findTopX(amount);
    }

}
