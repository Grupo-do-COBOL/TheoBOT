package br.mackenzie.theobot.events.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Ping {

    public static void handle(@NotNull SlashCommandInteractionEvent event){
        event.reply("Pong :ping_pong:").queue();
    }
}
