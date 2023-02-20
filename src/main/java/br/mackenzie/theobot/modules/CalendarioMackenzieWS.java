package br.mackenzie.theobot.modules;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CalendarioMackenzieWS {

    public boolean conexaoLoginMoodle() throws IOException {
        String urlLoginMoodle = "https://eadgrad.mackenzie.br/login/index.php";
        String usuarioMoodle = System.getenv("USUARIO_MACKENZIE");
        String senhaMoodle = System.getenv("SENHA_MACKENZIE");

        Connection.Response loginPage = Jsoup.connect(urlLoginMoodle)
                .method(Connection.Method.GET)
                .execute();

        Document loginDoc = loginPage.parse();
        Elements formulario = loginDoc.select("form");
        Element campoUsuario = formulario.select("input[name=username]").first();
        Element campoSenha = formulario.select("input[name=password]").first();

        assert campoUsuario != null;
        campoUsuario.val(usuarioMoodle);
        assert campoSenha != null;
        campoSenha.val(senhaMoodle);

        Connection.Response response = Jsoup.connect(urlLoginMoodle)
                .cookies(loginPage.cookies())
                .data(campoUsuario.attr("name"), usuarioMoodle)
                .data(campoSenha.attr("name"), senhaMoodle)
                .method(Connection.Method.POST)
                .execute();


        if (response.statusCode() == 200) {
            System.out.println("conexao com sucesso");
//            try {
//                String urlCalendario = "https://eadgrad.mackenzie.br/calendar/view.php";
//
//                Document conexaoCalendario = Jsoup.connect(urlCalendario)
//                        .cookies(loginPage.cookies())
//                        .get();
//
//                System.out.println(conexaoCalendario.body());
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }

        } else {
            System.out.println("nao deu certo nao");
        }
        return true;
    }


}
