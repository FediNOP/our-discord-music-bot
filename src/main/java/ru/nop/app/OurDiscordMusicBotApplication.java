package ru.nop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.nop")
public class OurDiscordMusicBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurDiscordMusicBotApplication.class, args);
    }

}
