package br.mackenzie.theobot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IcsToJsonConverter {

    public static String handle(String url) throws IOException, ParserException {
        // Obtem o ICS da URL
        URL ICSurl = new URL(url);

        // Cria o Builder do Calendar para transformar em iCalendar
        CalendarBuilder builder = new CalendarBuilder();

        // Lê o arquivo ICS e transforma em objeto iCalendar
        Calendar calendar;
        try (InputStream in = ICSurl.openStream()) {
            calendar = builder.build(in);
        }

        // Instancia o Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Converte em JSON

        // imprime o json

        return mapper.writeValueAsString(calendar);


    };



}
