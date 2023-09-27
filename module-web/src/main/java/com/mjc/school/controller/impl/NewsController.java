package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandBody;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.controller.annotations.CommandParam;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.implementation.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Component
@Controller
public class NewsController implements BaseController<NewsDtoRequest, NewsDtoResponse, Long> {
    private final BaseService<NewsDtoRequest, NewsDtoResponse, Long> newsService;
    private static Long lastNewsId;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
        lastNewsId = (long)newsService.readAll().size();
    }

    @Override
    @CommandHandler(value = "getAllNews")
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @Override
    @CommandHandler(value = "GetNewsById")
    public NewsDtoResponse readById(@CommandParam("newsId")Long id) {
        return newsService.readById(id);
    }

    @Override
    @CommandHandler(value = "createNews")
    public NewsDtoResponse create(@CommandBody NewsDtoRequest createRequest) {
        return newsService.create(createRequest);
    }

    @Override
    @CommandHandler(value = "updateNews")
    public NewsDtoResponse update(@CommandBody NewsDtoRequest updateRequest) {
        return newsService.update(updateRequest);
    }

    @Override
    @CommandHandler(value = "deleteNews")
    public boolean deleteById(@CommandParam("newsId")Long id) {
        return newsService.deleteById(id);
    }

    public static Long getLastNewsId() {
        return lastNewsId;
    }

    public static void setLastNewsId(Long providedLastNewsId) {
    }
}
