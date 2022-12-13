package pedro.com.br.filmespopulares.data.network;

import pedro.com.br.filmespopulares.data.network.response.FilmesResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
