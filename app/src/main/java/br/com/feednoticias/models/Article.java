package br.com.feednoticias.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Article {

    @SerializedName("source")
    @Expose
    private Source fonte;

    @SerializedName("author")
    @Expose
    private String autor;

    @SerializedName("title")
    @Expose
    private String titulo;

    @SerializedName("description")
    @Expose
    private String descricao;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    private String urlToImg;

    @SerializedName("publishedAt")
    @Expose
    private String publicado;



    //GETTER`S AND SETTER`S
    public Source getFonte() {
        return fonte;
    }

    public void setFonte(Source fonte) {
        this.fonte = fonte;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImg() {
        return urlToImg;
    }

    public void setUrlToImg(String urlToImg) {
        this.urlToImg = urlToImg;
    }

    public String getPublicado() {
        return publicado;
    }

    public void setPublicado(String publicado) {
        this.publicado = publicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
