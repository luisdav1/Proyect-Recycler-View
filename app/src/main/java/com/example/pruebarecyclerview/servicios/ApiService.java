package com.example.pruebarecyclerview.servicios;

import com.example.pruebarecyclerview.clases.CharacterResponse;
import com.example.pruebarecyclerview.clases.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("character")
    Call<CharacterResponse> getCharacters();

}

