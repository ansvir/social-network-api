package org.example.socialnetworkapi.mapper;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.BDDAssumptions.given;

public class SocialNetworkPostMapperTest {

    @Test
    public void testMapToApi() {
        // given
        Instant now = Instant.now();
        SocialNetworkPostModel model = new SocialNetworkPostModel(
                now,
                "Some Author",
                "Some Content",
                23452L);
        model.setId(1L);
        SocialNetworkPost api = new SocialNetworkPost(
            1L, now, "Some Author", "Some Content", 23452L);

        // when
        SocialNetworkPost result = SocialNetworkPostMapper.toApi(model);

        // then
        given(api).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void testMapToModel() {
        // given
        Instant now = Instant.now();
        SocialNetworkPostModel model = new SocialNetworkPostModel(
                now,
                "Some Author",
                "Some Content",
                23452L);
        model.setId(1L);
        SocialNetworkPost api = new SocialNetworkPost(
                1L, now, "Some Author", "Some Content", 23452L);

        // when
        SocialNetworkPostModel result = SocialNetworkPostMapper.toModel(api);
        result.setId(1L);

        // then
        given(model).usingRecursiveComparison().isEqualTo(result);
    }

}
