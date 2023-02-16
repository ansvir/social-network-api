package org.example.socialnetworkapi.mapper;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;

/**
 * Utility class for mapping {@link SocialNetworkPost} into database model and vice versa.
 * Useful for conversion Java Beans into plain JSON objects and vice versa.
 * Generally, serves to divide application and database layers
 *
 * @since 0.0.1-SNAPSHOT
 */
public class SocialNetworkPostMapper {

    public static SocialNetworkPost toApi(SocialNetworkPostModel model) {
        return new SocialNetworkPost(model.getId(), model.getPostDate(),
                model.getAuthor(), model.getContent(), model.getViewCount());
    }

    public static SocialNetworkPostModel toModel(SocialNetworkPost api) {
        SocialNetworkPostModel model = new SocialNetworkPostModel(api.getPostDate(), api.getAuthor(),
                api.getContent(), api.getViewCount());
        model.setId(api.getId());
        return model;
    }

}
