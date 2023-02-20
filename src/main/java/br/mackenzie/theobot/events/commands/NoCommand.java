package br.mackenzie.theobot.events.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class NoCommand {

    public static void handle(@NotNull SlashCommandInteractionEvent event){
        event.reply("Comando inexistente ou inválido").queue();
    }
}
