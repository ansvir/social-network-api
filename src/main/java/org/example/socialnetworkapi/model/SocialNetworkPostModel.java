package org.example.socialnetworkapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

/**
 * {@link SocialNetworkPost} ORM model for database operations
 */

@Table(name = "social_network_post")
public class SocialNetworkPostModel implements Persistable<Long> {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private Instant postDate;
    @Size(max = 50)
    private String author;
    @Size(max = 256)
    private String content;
    @NotNull
    private Long viewCount;

    public SocialNetworkPostModel(Instant postDate, String author, String content, Long viewCount) {
        this.postDate = postDate;
        this.author = author;
        this.content = content;
        this.viewCount = viewCount;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "SocialNetworkPost{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }

}
