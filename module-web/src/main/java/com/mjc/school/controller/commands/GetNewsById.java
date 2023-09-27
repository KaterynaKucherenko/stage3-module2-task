package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class GetNewsById implements BaseCommand{
    BaseController<NewsDtoRequest, NewsDtoResponse,Long> newsController;
    Scanner scanner;
    public GetNewsById(NewsController newsController,Scanner scanner){
        this.newsController = newsController;
        this.scanner = scanner;
    }
    @Override
    public void execute() {
        System.out.println("Write News id:");
        boolean isTrue = false;
        while (!isTrue) {
            try {
                System.out.println(newsController.readById(scanner.nextLong()));
                isTrue = true;
            }
            catch (ValidationException e){
                throw new ValidationException("News id is invalid");
            }
        }

    }
}
