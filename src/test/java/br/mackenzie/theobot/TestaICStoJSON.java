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
        // Define a URL do arquivo ICS
        String url = "https://eadgrad.mackenzie.br/calendar/export_execute.php?userid=45920&authtoken=84c9950e4c9781a1106420690b19963884c397be&preset_what=all&preset_time=monthnowhttps://eadgrad.mackenzie.br/calendar/export_execute.php?userid=45920&authtoken=84c9950e4c9781a1106420690b19963884c397be&preset_what=all&preset_time=monthnow";

        // Meios de se capturar o JSON (URL/Arquivo)
//      String jsonURL = IcsToJsonConverter.handle(url);
        String jsonFile = Files.readString(Paths.get("C:\\Users\\f-mat\\OneDrive\\GrupoDoCobol\\src\\test\\java\\br\\mackenzie\\theobot\\calendar.json"), StandardCharsets.UTF_8);

        // Escolhe como quer utilizar, pra não mandar req toda vez que executar eu peguei o arquivo
        String jsonString = jsonFile;
        ObjectMapper objectMapper = new ObjectMapper();

        // Pega a quantidade de eventos para usar num FOR LOOP
        int componentsLength = objectMapper.readTree(jsonString).get("components").size();
//        System.out.println(componentsLength);

        // For Loop
        for (int i = 0; i < componentsLength; i++) {
            // Obtém o nome do evento.
            String nomeEvento = String.valueOf(objectMapper.readTree(
                            jsonString)
                    .get("components").get(i)
                    .get("properties").get(1).get("value")
            );
            // Obtém dia do evento. O dia do evento é retornado em um formato que precisa ser parseado e formatado
            long dateStamp = Long.parseLong(String.valueOf(objectMapper.readTree(
                            jsonString)
                    .get("components").get(i)
                    .get("properties").get(6).get("date")
            ));

            // Aqui se formata, de milisegundos para data. E também formata para Dia, Mês e Ano"
            String dateTimeString = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(dateStamp), ZoneId.of("GMT-3"))
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            //Agora você pode fazer o que quiser com as informações. No caso eu estou printando.
            System.out.println("[description: " + nomeEvento +", datetime: " + dateTimeString+"]");
        }



    }
}
