package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;

import java.util.Scanner;

public class CreateAuthor implements CommandBase {
    private AuthorController authorController;
    private Scanner scanner;

    public CreateAuthor(AuthorController authorController) {
        this.authorController = authorController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        AuthorDtoRequest authorDtoRequest = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println(CommandType.CREATE_AUTHOR.getCommandType());
                System.out.println("Write author name:");
                String name = scanner.nextLine();
                Long authorId = Long.valueOf(authorController.readAll().size());
                authorDtoRequest = new AuthorDtoRequest(authorId, name);
                System.out.println(authorController.create(authorDtoRequest));
                isValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }


}

