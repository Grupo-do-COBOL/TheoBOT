package br.mackenzie.theobot.events.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RepeatCommand {

    public static void handle(@NotNull SlashCommandInteractionEvent event){
        String message = Objects.requireNonNull(event.getOption("repetir")).getAsString();
        event.reply("Seu teste deu certo, sua mensagem foi: " +
                        message + " :repeat: ").queue();
    }
}
