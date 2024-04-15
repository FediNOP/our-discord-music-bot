package ru.nop.configuration;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.EventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JDAConfiguration {

    @Value("${application.bot.token}")
    private String botToken;

    @Bean
    public JDA jda(List<EventListener> eventListeners) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(botToken)
                .setActivity(Activity.of(Activity.ActivityType.LISTENING, "Gachi remix"))
                .setStatus(OnlineStatus.ONLINE)
                ;
        eventListeners.forEach(jdaBuilder::addEventListeners);
        return jdaBuilder.build();
    }

    @Bean
    public AudioPlayerManager audioPlayerManager() {
        DefaultAudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);
        return playerManager;
    }

}
