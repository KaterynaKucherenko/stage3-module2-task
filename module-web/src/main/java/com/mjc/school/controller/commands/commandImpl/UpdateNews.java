package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;

import java.util.Scanner;

public class UpdateNews implements CommandBase {
    private NewsController newsController;
    private Scanner scanner;

    public UpdateNews(NewsController newsController) {
        this.newsController = newsController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        NewsDtoRequest newsDtoRequest = null;
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.UPDATE_NEWS.getCommandType());
                System.out.println("Write news ID for update: ");
                Long newsId = Long.parseLong(scanner.nextLine());
                System.out.println("Write news title for update: ");
                String title = scanner.nextLine();
                System.out.println("Write news content for update: ");
                String content = scanner.nextLine();
                System.out.println("Write author ID for update: ");
                Long authorId = scanner.nextLong();
                newsDtoRequest = new NewsDtoRequest(newsId, title, content, authorId);
                System.out.println(newsController.update(newsDtoRequest));
                isValue = true;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}