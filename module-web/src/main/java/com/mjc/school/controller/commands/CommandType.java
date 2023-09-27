package com.mjc.school.controller.commands;

public enum CommandType {
    CREATE_NEWS(1, "Create News"),
    GET_ALL_NEWS(2, " Get All News"),
    GET_NEWS_BY_ID(3, "Get News by id"),
    UPDATE_NEWS(4, "Update News"),
    DELETE_NEWS(5, "Delete News"),
    CREATE_AUTHOR(6, "Create Author"),
    GET_ALL_AUTHORS(7, "Get All Authors"),
    GET_AUTHOR_BY_ID(8, "Get Author by id"),
    UPDATE_AUTHOR(9, "Update Author"),
    DELETE_AUTHOR(10, "Delete Author"),
    EXIT(0, "Return to the menu");
    private final Integer numberOfCommand;
    private final String nameOfCommand;

    CommandType(Integer numberOfCommand, String nameOfCommand) {
        this.numberOfCommand = numberOfCommand;
        this.nameOfCommand = nameOfCommand;
    }

    public String getCommandType() {
        return "Operation: " + nameOfCommand;
    }

    public int getNumberOfCommand() {
        return numberOfCommand;
    }
}