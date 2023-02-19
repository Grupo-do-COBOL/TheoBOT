package br.mackenzie.theobot.events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MessageEventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);

        System.out.println("[Servidor - " + event.getGuild().getName()+ "] O "
                + event.getAuthor().getName()
                + " enviou uma mensagem no canal: ["
                + event.getChannel().getName()
                + "], olha só a mensagem: "
                + Arrays.toString(event.getMessage().getContentRaw().split(" ")));

    }
}
