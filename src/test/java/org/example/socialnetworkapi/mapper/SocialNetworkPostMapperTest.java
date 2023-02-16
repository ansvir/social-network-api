package org.example.socialnetworkapi.mapper;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.BDDAssumptions.given;

public class SocialNetworkPostMapperTest {

    @Test
    public void testMapToApi() {
        // given
        Date date = Date.valueOf(LocalDate.now());
        SocialNetworkPostModel model = new SocialNetworkPostModel(
                date,
                "Some Author",
                "Some Content",
                23452L);
        model.setId(1L);
        SocialNetworkPost api = new SocialNetworkPost(
            1L, date, "Some Author", "Some Content", 23452L);

        // when
        SocialNetworkPost result = SocialNetworkPostMapper.toApi(model);

        // then
        given(api).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void testMapToModel() {
        // given
        Date date = Date.valueOf(LocalDate.now());
        SocialNetworkPostModel model = new SocialNetworkPostModel(
                date,
                "Some Author",
                "Some Content",
                23452L);
        model.setId(1L);
        SocialNetworkPost api = new SocialNetworkPost(
                1L, date, "Some Author", "Some Content", 23452L);

        // when
        SocialNetworkPostModel result = SocialNetworkPostMapper.toModel(api);

        // then
        given(model).usingRecursiveComparison().isEqualTo(result);
    }

}
