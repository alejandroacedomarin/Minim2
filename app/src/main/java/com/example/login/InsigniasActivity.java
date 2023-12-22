package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.login.ModelosDeClases.Badges;
import com.example.login.ModelosDeClases.ProductoVo;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InsigniasActivity extends AppCompatActivity {
    private ArrayList<Badges> listBadges;
    private AdapterDatos2 adaptador;
    private RecyclerView recyclerProd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insignias);

        listBadges=new ArrayList<>();
        recyclerProd=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerProd.setLayoutManager(new LinearLayoutManager(this));


        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggin);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        InsigniasService badges = retrofit.create(InsigniasService.class);
        Call<ArrayList<Badges>> call = badges.getInsignias(SessionManager.getLoggedUsername(this));        call.enqueue(new Callback<ArrayList<Badges>>() {
            @Override
            public void onResponse(Call<ArrayList<Badges>> call, Response<ArrayList<Badges>> response) {
                if (response.isSuccessful()){
                    ArrayList<Badges> listBadges= response.body();

                    AdapterDatos2 adapter=new AdapterDatos2(listBadges,InsigniasActivity.this);

                    recyclerProd.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Badges>> call, Throwable t) {
                Toast.makeText(InsigniasActivity.this,"error",Toast.LENGTH_SHORT).show();
            }


        });

    }
}