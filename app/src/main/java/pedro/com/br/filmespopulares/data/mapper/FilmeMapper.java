package pedro.com.br.filmespopulares.data.mapper;

import java.util.ArrayList;
import java.util.List;

import pedro.com.br.filmespopulares.data.model.Filme;
import pedro.com.br.filmespopulares.data.network.response.FilmeResponse;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse){
        List<Filme> listaFilmes = new ArrayList<>();
        for (FilmeResponse filmeResponse : listaFilmeResponse){
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilmes.add(filme);
        }
        return listaFilmes;
    }
}
