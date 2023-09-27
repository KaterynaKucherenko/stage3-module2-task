package com.mjc.school.repository.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class NewsModel implements BaseEntity<Long> {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel() {

    }

    public NewsModel(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }


    public String getTitle() {
        return title;
    }

    @Required
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    @Required
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }


    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }


    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }


    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    @Required
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        NewsModel newsModel = (NewsModel) obj;
        return id == newsModel.id &&
                (title == newsModel.title || (title != null && title.equals(newsModel.getTitle()))) &&
                (content == newsModel.content || (content != null && content.equals(newsModel.getContent()))) &&
                (createDate == newsModel.createDate || (createDate != null && createDate.equals(newsModel.getCreateDate()))) &&
                (lastUpdateDate == newsModel.lastUpdateDate || (lastUpdateDate != null && lastUpdateDate.equals(newsModel.getLastUpdateDate()))) &&
                (authorId == newsModel.authorId || (authorId != null && authorId.equals(newsModel.getAuthorId())));
    }

    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);
    }

    public String toString() {
        return "news ID: " + id + ", title: " + title + ", content: " + content + ", create date: " + createDate + ", last update date: " + lastUpdateDate + ", author's ID: " + authorId;
    }
}
