package com.mjc.school.repository.model;

import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class AuthorModel implements BaseEntity<Long> {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;


    public AuthorModel() {
    }

    public AuthorModel(Long id, String name, LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        AuthorModel authorModel = (AuthorModel) obj;
        return id == authorModel.id &&
                (name == authorModel.name || (name != null && name.equals(authorModel.getName()))) &&
                (createDate == authorModel.createDate || (createDate != null && createDate.equals(authorModel.getCreateDate()))) &&
                (lastUpdateDate == authorModel.lastUpdateDate || (lastUpdateDate != null && lastUpdateDate.equals(authorModel.getLastUpdateDate())));
    }

    public int hashCode() {
        return Objects.hash(id, name, createDate, lastUpdateDate);
    }

    public String toString() {
        return "Author's ID: " + id + ", author's name: " + name + ", create date: " + createDate + ", last update date: " + lastUpdateDate;
    }
}
