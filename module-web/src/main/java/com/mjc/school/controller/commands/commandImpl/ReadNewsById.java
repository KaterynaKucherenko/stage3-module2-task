package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.NewsController;

import java.util.Scanner;

public class ReadNewsById implements CommandBase {
    private NewsController newsController;
    private Scanner scanner;

    public ReadNewsById(NewsController newsController) {
        this.newsController = newsController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                {
                    System.out.println(CommandType.GET_NEWS_BY_ID.getCommandType());
                    System.out.println("Write news ID: ");
                    Long newsId = scanner.nextLong();
                    System.out.println(newsController.readById(newsId));
                    isValue = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
