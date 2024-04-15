package ru.nop.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.springframework.lang.NonNull;

public interface Command {

    void execute(SlashCommandInteractionEvent event);

    @NonNull
    String getCommandName();

    @NonNull
    CommandData getCommandData();

}
