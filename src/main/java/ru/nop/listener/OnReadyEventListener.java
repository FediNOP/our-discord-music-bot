package ru.nop.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.springframework.stereotype.Component;
import ru.nop.command.Command;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class OnReadyEventListener extends ListenerAdapter {

    private final List<Command> commands;

    @Override
    public void onReady(ReadyEvent event) {
        List<CommandData> commandDataList = commands.stream().map(Command::getCommandData).toList();
        event.getJDA()
                .updateCommands()
                .addCommands(commandDataList)
                .queue(commandList -> commandList.forEach(command -> log.info("Command {} added",command.getName())));
    }
}
