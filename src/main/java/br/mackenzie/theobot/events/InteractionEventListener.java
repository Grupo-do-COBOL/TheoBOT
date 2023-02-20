package br.mackenzie.theobot.events;

import br.mackenzie.theobot.modules.CalendarioMackenzieWS;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class InteractionEventListener extends ListenerAdapter {


    private final CalendarioMackenzieWS calendario = new CalendarioMackenzieWS();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        System.out.println("[Console] O modulo de interacao está funcionando");
        switch (event.getName()) {
            case "ping":

//                try {
////                    System.out.println(calendario.conexaoLoginMoodle());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                event.reply("Este e um pong").queue();
                break;
        }


    }
}