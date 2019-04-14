package br.com.feednoticias.api;

import br.com.feednoticias.models.Noticias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Noticias> getNews(
      @Query("country") String country ,
      @Query("apiKey") String apiKey
    );
}
