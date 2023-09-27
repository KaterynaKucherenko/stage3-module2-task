package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;

import java.util.Scanner;

public class UpdateAuthor implements CommandBase {
    private AuthorController authorController;
    private Scanner scanner;

    public UpdateAuthor(AuthorController authorController) {
        this.authorController = authorController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        AuthorDtoRequest authorDtoRequest = null;
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.UPDATE_AUTHOR.getCommandType());
                System.out.println("Write author ID for update: ");
                Long authorId = Long.parseLong(scanner.nextLine());
                System.out.println("Write author name:");
                String authorName = scanner.nextLine();
                authorDtoRequest = new AuthorDtoRequest(authorId, authorName);
                System.out.println(authorController.update(authorDtoRequest));
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
