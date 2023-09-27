package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;

import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.implementation.AuthorController;

import java.util.Scanner;

public class ReadAuthorById implements CommandBase {
    private AuthorController authorController;
    private Scanner scanner;

    public ReadAuthorById(AuthorController authorController) {
        this.authorController = authorController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.GET_AUTHOR_BY_ID.getCommandType());
                System.out.println("Write author ID: ");
                Long authorId = scanner.nextLong();
                System.out.println(authorController.readById(authorId));
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
