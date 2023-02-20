package br.mackenzie.theobot.events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class MessageEventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String[] messageSent = event.getMessage().getContentRaw().split(" ");

        for (int i = 0; i < messageSent.length; i++) {
            if (messageSent[i].equalsIgnoreCase("hi")){
                if(!Objects.requireNonNull(event.getMember()).getUser().isBot()) {
                    event.getChannel().sendMessage("hi").queue();
                }
                break;
            }
        }



        System.out.println("[Servidor - " + event.getGuild().getName()+ "] O "
                + event.getAuthor().getName()
                + " enviou uma mensagem no canal: ["
                + event.getChannel().getName()
                + "], olha só a mensagem: "
                + (event.getMessage().getContentRaw()));

    }
}
