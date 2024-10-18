package com.example.pruebarecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pruebarecyclerview.clases.Character;
import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private ImageView ivCharacterImage;
    private TextView tvCharacterName, tvCharacterStatus, tvCharacterSpecies, tvCharacterGender, tvCharacterOrigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        ivCharacterImage = findViewById(R.id.ivCharacterImage);
        tvCharacterName = findViewById(R.id.tvCharacterName);
        tvCharacterStatus = findViewById(R.id.tvCharacterStatus);
        tvCharacterSpecies = findViewById(R.id.tvCharacterSpecies);
        tvCharacterGender = findViewById(R.id.tvCharacterGender);
        tvCharacterOrigin = findViewById(R.id.tvCharacterOrigen);

        // Obtener el objeto Character desde el Intent
        Character character = getIntent().getParcelableExtra("character");

        if (character != null) {
            tvCharacterName.setText(character.getName());
            tvCharacterStatus.setText(character.getStatus());
            tvCharacterSpecies.setText(character.getSpecies());
            tvCharacterGender.setText(character.getGender());
            tvCharacterOrigin.setText(character.getOrigin().getName());

            Picasso.get().load(character.getImage()).into(ivCharacterImage);
        }
    }
}

