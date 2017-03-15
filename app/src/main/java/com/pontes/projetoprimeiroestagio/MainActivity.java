package com.pontes.projetoprimeiroestagio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Ao clicar 'entrar', redireciona para a segunda tela
    public void entrar(View v){
        btEntrar = (Button) findViewById(R.id.btEntrar);
        startActivity(new Intent(MainActivity.this, Activity_tela02.class));
    }
}
