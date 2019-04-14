package br.com.feednoticias.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Noticias {

    @SerializedName("status")
    @Expose
    private String Status;

    @SerializedName("totalResults")
    @Expose
    private int totalResult;

    @SerializedName("articles")
    @Expose
    private List<Article> articles;


    //GETTER`S AND SETTER`S
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
