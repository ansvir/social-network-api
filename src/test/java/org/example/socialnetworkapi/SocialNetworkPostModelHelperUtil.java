package org.example.socialnetworkapi;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.example.socialnetworkapi.model.SocialNetworkPostModel;

import java.time.Instant;
import java.util.Random;

/**
 * Utility class for helping create fake {@link SocialNetworkPost} objects
 *
 * @since 0.0.1-SNAPSHOT
 */
public class SocialNetworkPostModelHelperUtil {

    /**
     * Not idempotent method to generate random {@link SocialNetworkPost} model
     * for testing purposes. Warning! Result unexpected
     * @return random model {@link SocialNetworkPostModel}
     */
    public static SocialNetworkPostModel randomModelPost() {
        long now = System.currentTimeMillis();
        Random random = new Random();
        SocialNetworkPostModel model = new SocialNetworkPostModel(Instant.ofEpochMilli(now),
                fakeString(now, random.nextInt(50)),
                fakeString(now, random.nextInt(255)),
                random.nextLong(2000000L));
        model.setId(now);
        return model;
    }

    /**
     * Not idempotent method to generate random {@link SocialNetworkPost}
     * for testing purposes. Warning! Result unexpected
     * @return random model {@link SocialNetworkPost}
     */
    public static SocialNetworkPost randomApiPost() {
        long now = System.currentTimeMillis();
        Random random = new Random();
        return new SocialNetworkPost(
                now,
                Instant.ofEpochMilli(now),
                fakeString(now, random.nextInt(50)),
                fakeString(now, random.nextInt(255)),
                random.nextLong(2000000L));
    }

    private static String fakeString(long seed, int length) {
        StringBuilder result = new StringBuilder();
        Random random = new Random(seed);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 0123456789";
        for (int i = 0 ; i < length; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }
}
