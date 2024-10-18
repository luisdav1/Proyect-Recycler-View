package com.example.pruebarecyclerview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.example.pruebarecyclerview.adaptadores.UsuarioAdaptador;
import com.example.pruebarecyclerview.clases.Character;
import com.example.pruebarecyclerview.clases.CharacterResponse;
import com.example.pruebarecyclerview.clases.Usuario;
import com.example.pruebarecyclerview.servicios.ApiClient;
import com.example.pruebarecyclerview.servicios.ApiService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_usuarios;
    List<Usuario> listaUsuarios = new ArrayList<>();
    MainActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getApiService();
        Call<CharacterResponse> call = apiService.getCharacters();

        call.enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Character> characters = response.body().getResults();
                    rcv_usuarios = findViewById(R.id.rcv_usuarios);
                    rcv_usuarios.setLayoutManager(new LinearLayoutManager(context));
                    rcv_usuarios.setAdapter(new UsuarioAdaptador(characters));
                }
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        // Configurar el botón de Logout
        Button logoutButton = findViewById(R.id.btn_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar las preferencias guardadas (logout)
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();  // Eliminar todos los datos guardados
                editor.apply();

                // Redirigir al usuario a la pantalla de LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();  // Finalizar MainActivity para que no se pueda volver atrás
            }
        });

        // Obtener el TextView para el saludo
        TextView greetingTextView = findViewById(R.id.tv_greeting);

        // Obtener el nombre del usuario desde SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "Usuario");

        // Actualizar el título con el nombre del usuario
        greetingTextView.setText("Hola, " + username + "!");
    }
}