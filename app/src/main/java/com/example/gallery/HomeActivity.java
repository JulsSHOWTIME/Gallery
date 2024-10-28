package com.example.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {

    private String urlImage = "https://goo.gl/gEgYUd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView ivAndroid = findViewById(R.id.ivAndroid);

        ivAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                if(!urlImage.contains("http://")){
                    urlImage = "http://" + urlImage;
                }

                intent.setData(Uri.parse(urlImage));
                startActivity(intent);
            }
        });

        Button btChangeImg = findViewById(R.id.btChangeImg);

        btChangeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ivAndroid.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.android2, null));

                //Hemos implementado Glide en libs.version.toml (settings.gradle.kts) para poder utilizar imagenes de internet en vez de en local
                //Esta parte del código sirve para acceder a una imagen de internet
                Glide.with(HomeActivity.this).load("https://goo.gl/gEgYUd").into(ivAndroid);
            }
        });
    }
}