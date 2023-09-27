package com.mjc.school.repository.aspects;

import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.model.impl.NewsModel;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OnDeleteAspect {
    DataSource dataSource;
    @Autowired
    public OnDeleteAspect(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @AfterReturning(value = "@annotation(com.mjc.school.repository.aspects.OnDelete)&& args(id)")
    public void onDelete(Long id){
        List<NewsModel> newsFiltered= dataSource.getNewsModels();
        List<NewsModel>filteredList = newsFiltered.stream().filter(news->news.getAuthorId().equals(id)).toList();
        newsFiltered.removeAll(filteredList);
    }

}
