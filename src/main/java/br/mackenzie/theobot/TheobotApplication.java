package br.mackenzie.theobot;

import br.mackenzie.theobot.config.TokenConfig;
import br.mackenzie.theobot.events.InteractionEventListener;
import br.mackenzie.theobot.events.MessageEventListener;
import br.mackenzie.theobot.events.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;


@SpringBootApplication
public class TheobotApplication {

    public static void main(String[] args) {
        TokenConfig token = new TokenConfig();
        JDABuilder jdaBuilder = JDABuilder.createDefault(token.getToken());

        JDA jda = jdaBuilder.setActivity(Activity.playing("Em desenvolvimento"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(
                        new InteractionEventListener(),
                        new MessageEventListener(),
                        new ReadyEventListener()
                )
                .build();


        jda.upsertCommand("ping", "comando de teste").setGuildOnly(true).queue();
        jda.upsertCommand("teste", "outro comando de teste").setGuildOnly(true).queue();
        SpringApplication.run(TheobotApplication.class, args);
    }
}
