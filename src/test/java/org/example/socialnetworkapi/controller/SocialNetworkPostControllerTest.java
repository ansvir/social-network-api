package org.example.socialnetworkapi.controller;

import org.example.socialnetworkapi.SocialNetworkPostModelHelperUtil;
import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.mapper.SocialNetworkPostMapper;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;
import org.example.socialnetworkapi.repository.SocialNetworkPostRepository;
import org.example.socialnetworkapi.service.SocialNetworkPostServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import({ SocialNetworkPostServiceImpl.class, SocialNetworkPostController.class})
public class SocialNetworkPostControllerTest {

    @MockBean
    private SocialNetworkPostRepository postRepository;

    @Autowired
    private ReactiveWebServerApplicationContext webServerContext;

    @Test
    public void testGetAll() {

        // given
        SocialNetworkPostModel postOne = SocialNetworkPostModelHelperUtil.randomModelPost();
        SocialNetworkPostModel postTwo = SocialNetworkPostModelHelperUtil.randomModelPost();
        SocialNetworkPost apiOne = SocialNetworkPostMapper.toApi(postOne);
        SocialNetworkPost apiTwo = SocialNetworkPostMapper.toApi(postTwo);
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.findAll()).thenReturn(Flux.just(postOne, postTwo));

        // then
        testClient.get()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post").build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SocialNetworkPost.class)
                .contains(apiOne, apiTwo);
    }

    @Test
    public void testGetById() {

        // given
        SocialNetworkPostModel postOne = SocialNetworkPostModelHelperUtil.randomModelPost();
        postOne.setId(1L);
        SocialNetworkPost apiOne = SocialNetworkPostMapper.toApi(postOne);
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.findById(1L)).thenReturn(Mono.just(postOne));

        // then
        testClient.get()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post/1").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(SocialNetworkPost.class)
                .value(m -> given(m).usingRecursiveComparison().isEqualTo(apiOne));
    }

    @Test
    public void testCreateOrUpdate() {

        // given
        SocialNetworkPostModel postOne = SocialNetworkPostModelHelperUtil.randomModelPost();
        SocialNetworkPostModel postOneSaved = postOne.copy();
        postOneSaved.setId(1L);
        SocialNetworkPost apiOne = SocialNetworkPostMapper.toApi(postOne);
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.save(any(SocialNetworkPostModel.class))).thenReturn(Mono.just(postOneSaved));

        // then
        testClient.post()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post").build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(apiOne), SocialNetworkPost.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(SocialNetworkPost.class)
                .value(m -> given(m).usingRecursiveComparison()
                        .ignoringFields("id").isEqualTo(apiOne));
    }

    @Test
    public void testDeleteById() {

        // given
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.deleteById(1L)).thenReturn(Mono.empty());

        // then
        testClient.delete()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post/1").build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testDeleteAll() {

        // given
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.deleteAll()).thenReturn(Mono.empty());

        // then
        testClient.delete()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post").build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetTopTwo() {

        // given
        SocialNetworkPostModel postOne = SocialNetworkPostModelHelperUtil.randomModelPost();
        postOne.setViewCount(1111L);
        SocialNetworkPostModel postTwo = SocialNetworkPostModelHelperUtil.randomModelPost();
        postTwo.setViewCount(11111L);
        SocialNetworkPostModel postThree = SocialNetworkPostModelHelperUtil.randomModelPost();
        postThree.setViewCount(111L);
        SocialNetworkPost apiOne = SocialNetworkPostMapper.toApi(postOne);
        SocialNetworkPost apiTwo = SocialNetworkPostMapper.toApi(postTwo);
        SocialNetworkPost apiThree = SocialNetworkPostMapper.toApi(postThree);
        WebTestClient testClient = WebTestClient.bindToApplicationContext(webServerContext)
                .build();

        // when
        when(postRepository.findTopX(2L)).thenReturn(Flux.just(postTwo, postOne));

        // then
        testClient.get()
                .uri(uriBuilder -> uriBuilder.host("localhost")
                        .path("rest/v1/post/top/2").build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SocialNetworkPost.class)
                .contains(apiTwo, apiOne)
                .doesNotContain(apiThree);

    }

}
