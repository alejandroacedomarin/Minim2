package com.example.login;

import com.example.login.ModelosDeClases.Badges;
import com.example.login.ModelosDeClases.Jugador;
import com.example.login.ModelosDeClases.ProductoVo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InsigniasService {
    @GET("dsaApp/jugadores/{username}/badges")
    Call<ArrayList<Badges>> getInsignias(@Path("username") String username);
}
