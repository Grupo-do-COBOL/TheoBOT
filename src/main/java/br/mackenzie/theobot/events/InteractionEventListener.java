package br.mackenzie.theobot.events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InteractionEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        System.out.println("[Console] O modulo de interacao está funcionando");
        switch (event.getName()) {
            case "ping":
                event.reply("Pong").queue();
                break;

        }


    }
}