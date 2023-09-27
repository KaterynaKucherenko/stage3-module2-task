package com.mjc.school.controller.commands.commandImpl;

import com.mjc.school.controller.commands.CommandBase;
import org.springframework.stereotype.Component;

@Component
public class Invoker {
    private CommandBase commandBase;

    public void setCommand(CommandBase commandBase) {
        this.commandBase = commandBase;
        commandBase.execute();
    }
}
