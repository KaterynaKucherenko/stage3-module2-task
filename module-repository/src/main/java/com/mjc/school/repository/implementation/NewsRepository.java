package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.datasourse.NewsDataSource;
import com.mjc.school.repository.model.BaseEntity;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {
    private NewsDataSource newsDataSource;

    @Autowired
    public NewsRepository(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public List<NewsModel> readAll() {
        return newsDataSource.getNewsModelList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.ofNullable(this.newsDataSource.getNewsId(id));
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        newsModel.setId(newsDataSource.getLastNewsId());
        newsDataSource.getNewsModelList().add(newsModel);
        return newsModel;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        if (this.newsDataSource.getNewsId(newsModel.getId()) == null) {
            return null;
        }
        NewsModel newsForUpdate = this.newsDataSource.getNewsId(newsModel.getId());
        newsForUpdate.setTitle(newsModel.getTitle());
        newsForUpdate.setContent(newsModel.getContent());
        newsForUpdate.setLastUpdateDate(LocalDateTime.now());
        newsForUpdate.setAuthorId(newsModel.getAuthorId());
        int tmp = this.newsDataSource.getNewsModelList().indexOf(this.newsDataSource.getNewsId(newsModel.getId()));
        this.newsDataSource.getNewsModelList().remove(newsDataSource.getNewsId(newsModel.getId()));
        this.newsDataSource.getNewsModelList().add(tmp, newsForUpdate);
        return newsForUpdate;
    }

    @Override
    public boolean deleteById(Long id) {
        return newsDataSource.getNewsModelList().remove(newsDataSource.getNewsId(id));
    }

    @Override
    public boolean existById(Long id) {
        return this.newsDataSource.getNewsId(id) != null;
    }
}