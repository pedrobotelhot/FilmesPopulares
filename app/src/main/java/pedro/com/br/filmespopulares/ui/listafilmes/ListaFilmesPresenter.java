package pedro.com.br.filmespopulares.ui.listafilmes;

import androidx.annotation.NonNull;

import java.util.List;

import pedro.com.br.filmespopulares.data.mapper.FilmeMapper;
import pedro.com.br.filmespopulares.data.model.Filme;
import pedro.com.br.filmespopulares.data.network.ApiService;
import pedro.com.br.filmespopulares.data.network.response.FilmesResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {
    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("b41ef334a07f78c8e960cef236ea320f")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NonNull Call<FilmesResult> call, @NonNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            final List<Filme> listaFilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());

                            view.mostraFilmes(listaFilmes);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<FilmesResult> call, @NonNull Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruitView() {
        this.view = null;
    }
}
