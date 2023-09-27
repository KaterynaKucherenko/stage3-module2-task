package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CreateNews implements CommandBase {
    private NewsController newsController;
    private Scanner scanner;

    public CreateNews(NewsController newsController) {
        this.newsController = newsController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        NewsDtoRequest newsDtoRequest = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println(CommandType.CREATE_NEWS.getCommandType());
                System.out.println("Write news title: ");
                String title = scanner.nextLine();
                System.out.println("Write news content: ");
                String content = scanner.nextLine();
                System.out.println("Write author ID: ");
                Long authorId = scanner.nextLong();
                Long newsId = Long.valueOf(newsController.readAll().size());
                newsDtoRequest = new NewsDtoRequest(newsId, title, content, authorId);
                System.out.println(newsController.create(newsDtoRequest));
                isValid = true;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
