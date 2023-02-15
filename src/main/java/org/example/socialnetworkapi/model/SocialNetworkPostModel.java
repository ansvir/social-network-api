package org.example.socialnetworkapi.model;

import org.example.socialnetworkapi.api.SocialNetworkPost;
import org.springframework.data.annotation.Id;

import java.sql.Date;

/**
 * {@link SocialNetworkPost} ORM model for database operations
 */
public class SocialNetworkPostModel {

    @Id
    private Long id;
    private Date postDate;
    private String author;
    private String content;
    private Long viewCount;

    public SocialNetworkPostModel(Date postDate, String author, String content, Long viewCount) {
        this.postDate = postDate;
        this.author = author;
        this.content = content;
        this.viewCount = viewCount;
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
