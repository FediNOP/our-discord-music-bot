package ru.nop.command.impl;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.nop.command.Command;

@Component
public class PingCommand implements Command {

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("pong").queue();
    }

    @NotNull
    @Override
    public String getCommandName() {
        return "ping";
    }

    @NotNull
    @Override
    public CommandData getCommandData() {
        return Commands.slash(getCommandName(), "Pong");
    }

}
