package br.mackenzie.theobot.events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InteractionEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        System.out.println("[Console] O modulo de interacao está funcionando");
        switch (event.getName()) {
            case "ping":
                event.reply("Pong").queue();
                break;
            case "teste":
                event.reply("Seu teste deu certo, sua mensagem foi: " + Objects.requireNonNull(event.getOption("teste")).getAsString()).queue();
                break;
        }


    }
}