package br.com.feednoticias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import br.com.feednoticias.api.ApiClient;
import br.com.feednoticias.api.ApiInterface;
import br.com.feednoticias.models.Article;
import br.com.feednoticias.models.Noticias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "5c0e6b8715b04a7795c514607bbbe329";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        LoadJson();
    }

    public void LoadJson(){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String country = Utils.getCountry();

        Call<Noticias> call;
        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<Noticias>() {
            @Override
            public void onResponse(Call<Noticias> call, Response<Noticias> response) {
                if(response.isSuccessful() && response.body().getArticles() != null){
                    if(!articles.isEmpty()){
                        articles.clear();
                    }

                    articles = response.body().getArticles();
                    adapter = new Adapter(articles, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    initListener();
                }else{
                    Toast.makeText(MainActivity.this, "Sem resultados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Noticias> call, Throwable t) {

            }
        });
    }

    private void initListener(){
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(MainActivity.this, NoticiasDetailActivity.class);

                Article article = articles.get(position);
                i.putExtra("url", article.getUrl());
                i.putExtra("title", article.getTitulo());
                i.putExtra("img", article.getUrlToImg());
                i.putExtra("date", article.getPublicado());
                i.putExtra("source",article.getFonte().getNome());
                i.putExtra("author",article.getAutor());

                startActivity(i);
            }
        });
    }
}