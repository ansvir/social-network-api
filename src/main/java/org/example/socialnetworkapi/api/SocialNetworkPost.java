package org.example.socialnetworkapi.api;

import org.example.socialnetworkapi.model.SocialNetworkPostModel;

import java.sql.Date;
import java.util.Objects;

/**
 * {@link SocialNetworkPostModel} POJO for REST operations
 *
 * @since 0.0.1-SNAPSHOT
 */
public class SocialNetworkPost {

    private Long id;
    private Date postDate;
    private String author;
    private String content;
    private Long viewCount;

    public SocialNetworkPost(Long id, Date postDate, String author, String content, Long viewCount) {
        this.id = id;
        this.postDate = postDate;
        this.author = author;
        this.content = content;
        this.viewCount = viewCount;
    }

    public SocialNetworkPost() {
        // serialization constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetworkPost that = (SocialNetworkPost) o;
        return Objects.equals(id, that.id) && Objects.equals(postDate, that.postDate) && Objects.equals(author, that.author) && Objects.equals(content, that.content) && viewCount.equals(that.viewCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postDate, author, content, viewCount);
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
