package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;

import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.ArrayList;
import java.util.List;

public class GetAllNews implements CommandBase {

    private NewsController newsController;

    public GetAllNews(NewsController newsController) {
        this.newsController = newsController;
    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.GET_ALL_NEWS.getCommandType());
                newsController.readAll().stream().toList().forEach(System.out::println);
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
