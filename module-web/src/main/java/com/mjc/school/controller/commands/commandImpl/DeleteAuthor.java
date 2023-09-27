package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.implementation.AuthorServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DeleteAuthor implements CommandBase {
    private AuthorController authorController;
    private NewsController newsController;
    private Scanner scanner;

    public DeleteAuthor(AuthorController authorController, NewsController newsController) {
        this.authorController = authorController;
        this.newsController = newsController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.DELETE_AUTHOR.getCommandType());
                System.out.println("Write author ID for delete: ");
                Long authorId = scanner.nextLong();
                authorController.deleteById(authorId);
//                List<NewsDtoResponse> newsDtoResponseList = newsController.readAll().stream().filter(newsDtoResponse -> Objects.equals(newsDtoResponse.getAuthorId(), authorId)).toList();
//                newsDtoResponseList.forEach(newsDtoResponse -> newsController.deleteById(newsDtoResponse.getId()));
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
