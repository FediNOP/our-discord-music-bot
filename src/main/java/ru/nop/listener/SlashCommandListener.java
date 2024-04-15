package ru.nop.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.nop.command.Command;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SlashCommandListener extends ListenerAdapter {

    private final List<Command> commands;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commands.stream()
                .filter(command -> command.getCommandName().equals(event.getName()))
                .findFirst()
                .ifPresent(command -> command.execute(event));
    }

}
