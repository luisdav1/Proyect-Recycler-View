package com.example.pruebarecyclerview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Verificar si ya hay un usuario guardado
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        if (sharedPreferences.contains("username")) {
            // Si el usuario ya está guardado, ir a la pantalla principal
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Todos los campos son requeridos!", Toast.LENGTH_SHORT).show();
                } else {
                    // Guardar usuario en SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();

                    // Ir a la pantalla principal después de iniciar sesión
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();  // Finalizar la actividad de login para que no se pueda volver al presionar 'back'
                }
            }
        });
    }
}

