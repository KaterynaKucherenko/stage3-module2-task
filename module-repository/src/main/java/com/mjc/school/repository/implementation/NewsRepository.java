package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.model.impl.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {
    private final DataSource dataSource;

    @Autowired
    public NewsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsModels();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.ofNullable(dataSource.getNewsModels().get(id.intValue()-1));
    }

    @Override
    public NewsModel create(NewsModel entity) {
        this.dataSource.getNewsModels().add(entity);
        return entity;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        dataSource.getNewsModels().set((entity.getId().intValue()-1), entity);
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.getNewsModels().remove(dataSource.getNewsModels().get(id.intValue()));
    }

    @Override
    public boolean existById(Long id) {
        return dataSource.getNewsModels().get(id.intValue()) != null;
    }
}
