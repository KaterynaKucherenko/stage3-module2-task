package com.mjc.school.controller;

import com.mjc.school.controller.annotations.CommandBody;
import com.mjc.school.controller.commands.*;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ControllerCommands {
    NewsController newsController;
    AuthorController authorController;

    @Autowired
    public ControllerCommands(NewsController newsController, AuthorController authorController) {
        this.newsController = newsController;
        this.authorController = authorController;
    }

    public final String MenuBase = "Choose command:" + "\n" + "1- Get all authors " + "\n" + "2-Get all news" + "\n" + "3-Create author" + "\n" + "4-Create news" + "\n" + "5-Delete author" + "\n" + "6-Delete news" + "\n" + "7-Get author by ID" + "\n" + "8-Get news by ID" + "\n" + "9-Update author" + "\n" + "10-Update news" + "\n" + "0-Exit";

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int numberOfCommand = scanner1.nextInt();
        switch (numberOfCommand) {
            case 1 -> new GetAllAuthors(authorController).execute();
            case 2 -> new GetAllNews(newsController).execute();
            case 3 -> new CreateAuthor(authorController, scanner).execute();
            case 4 -> new CreateNews(newsController, scanner).execute();
            case 5 -> new DeleteAuthor(authorController, scanner).execute();
            case 6 -> new DeleteNews(newsController, scanner).execute();
            case 7 -> new GetAuthorById(authorController, scanner).execute();
            case 8 -> new GetNewsById(newsController, scanner).execute();
            case 9 -> new UpdateAuthor(authorController, scanner).execute();
            case 10 -> new UpdateNews(newsController, scanner).execute();
            case 0 -> System.exit(0);
        }
    }
        public void printMenu(){
            System.out.println(MenuBase);
        }

    }
