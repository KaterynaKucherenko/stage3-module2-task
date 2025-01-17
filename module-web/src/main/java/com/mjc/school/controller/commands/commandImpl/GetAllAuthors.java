package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import com.mjc.school.controller.commands.CommandType;
import com.mjc.school.controller.impl.AuthorController;

public class GetAllAuthors implements CommandBase {
    private AuthorController authorController;


    public GetAllAuthors(AuthorController authorController) {
        this.authorController = authorController;

    }

    @Override
    public void execute() {
        boolean isValue = false;
        while (!isValue) {
            try {
                System.out.println(CommandType.GET_ALL_AUTHORS.getCommandType());
                authorController.readAll().stream().toList().forEach(System.out::println);
                isValue = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
