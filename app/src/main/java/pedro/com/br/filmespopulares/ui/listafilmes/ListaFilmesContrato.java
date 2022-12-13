package pedro.com.br.filmespopulares.ui.listafilmes;

import java.util.List;

import pedro.com.br.filmespopulares.data.model.Filme;

public interface ListaFilmesContrato {
    interface ListaFilmesView{
        void mostraFilmes(List<Filme> filmes);
        void mostraErro();
    }
    interface ListaFilmesPresenter{
        void obtemFilmes();
        void destruitView();
    }
}
