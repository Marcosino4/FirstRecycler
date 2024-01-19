package com.example.firstrecicler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ModeloDivisas> listaDivisas = new ArrayList<ModeloDivisas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView rvDivisas = findViewById(R.id.recyclerView);
        setDivisas();

        MiAdaptador adaptador = new MiAdaptador(this, listaDivisas);
        rvDivisas.setAdapter(adaptador);
        rvDivisas.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setDivisas(){
        String[] divisas = getResources().getStringArray(R.array.divisas);
        String[] valores = getResources().getStringArray(R.array.valores);

        for(int i = 0; i < divisas.length; i++){
            listaDivisas.add(new ModeloDivisas(divisas[i], Float.parseFloat(valores[i])));
        }
    }

}