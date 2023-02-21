package br.mackenzie.theobot;

import br.mackenzie.theobot.config.IcsToJsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.fortuna.ical4j.data.ParserException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestaICStoJSON {
    public static void main(String[] args) throws ParserException, IOException {
        String url = "https://eadgrad.mackenzie.br/calendar/export_execute.php?userid=45920&authtoken=84c9950e4c9781a1106420690b19963884c397be&preset_what=all&preset_time=monthnowhttps://eadgrad.mackenzie.br/calendar/export_execute.php?userid=45920&authtoken=84c9950e4c9781a1106420690b19963884c397be&preset_what=all&preset_time=monthnow";
//        String jsonURL = IcsToJsonConverter.handle(url);
        String jsonFile = Files.readString(Paths.get("C:\\Users\\f-mat\\OneDrive\\GrupoDoCobol\\src\\test\\java\\br\\mackenzie\\theobot\\calendar.json"), StandardCharsets.UTF_8);
        String jsonString = jsonFile;
        ObjectMapper objectMapper = new ObjectMapper();

        int componentsLength = objectMapper.readTree(jsonString).get("components").size();
        System.out.println(componentsLength);

        for (int i = 0; i < componentsLength; i++) {
            String nomeEvento = String.valueOf(objectMapper.readTree(
                            jsonString)
                    .get("components").get(i)
                    .get("properties").get(1).get("value")
            );
            long dateStamp = Long.parseLong(String.valueOf(objectMapper.readTree(
                            jsonString)
                    .get("components").get(i)
                    .get("properties").get(6).get("date")
            ));
            String dateTimeString = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(dateStamp), ZoneId.of("GMT-3"))
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            System.out.println("[description: " + nomeEvento +", datetime: " + dateTimeString+"]");
        }



    }
}
