package br.mackenzie.theobot.events;

import br.mackenzie.theobot.events.commands.NoCommand;
import br.mackenzie.theobot.events.commands.Ping;
import br.mackenzie.theobot.events.commands.RepeatCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InteractionEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        System.out.println("[Console] Módulo Interações está funcionando");
        switch (event.getName()) {
            case "ping" -> Ping.handle(event);
            case "repeat" -> RepeatCommand.handle(event);
            default -> NoCommand.handle(event);
        }


    }
}