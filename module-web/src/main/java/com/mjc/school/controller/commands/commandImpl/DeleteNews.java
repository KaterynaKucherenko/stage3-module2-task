package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.impl.NewsController;

import java.util.Scanner;

public class DeleteNews implements CommandBase {
    private NewsController newsController;
    private Scanner scanner;

    public DeleteNews(NewsController newsController) {
        this.newsController = newsController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.DELETE_NEWS.getCommandType());
                System.out.println("Write news ID for delete: ");
                Long newsId = scanner.nextLong();
                newsController.deleteById(newsId);
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}




