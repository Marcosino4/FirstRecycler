package com.example.firstrecicler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ModeloDivisas> listaDivisas = new ArrayList<ModeloDivisas>();
    EditText divisa;
    Button convertir;
    Switch clienteVIP;
    MiAdaptador adaptador;
    TextView conversion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvDivisas = findViewById(R.id.recyclerView);
        setDivisas();

        adaptador = new MiAdaptador(this, listaDivisas);
        rvDivisas.setAdapter(adaptador);
        rvDivisas.setLayoutManager(new LinearLayoutManager(this));

        divisa = findViewById(R.id.divisa);
        convertir = findViewById(R.id.convertir);
        clienteVIP = findViewById(R.id.clienteVIP);
        conversion = findViewById(R.id.conversion);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });


    }

    public void convert(){

        if(!divisa.getText().toString().isEmpty() && adaptador.posicionSelec >= 0){
            float div = Float.parseFloat(divisa.getText().toString());
            float convert;

            if(clienteVIP.isChecked()){
                convert = adaptador.selecDivisa.getValue() * div;
            }else{
                convert = adaptador.selecDivisa.getValue() * div * 1.02f;
            }
            String conv = String.valueOf(convert);
            conversion.setText(conv);
        }else if(divisa.getText().toString().isEmpty()){
            Toast.makeText(this, "Porfavor, introduce una cantidad", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Porfavor, selecciona una moneda", Toast.LENGTH_SHORT).show();
        }
    }
    private void setDivisas() {
        String[] divisas = getResources().getStringArray(R.array.divisas);
        String[] valores = getResources().getStringArray(R.array.valores);

        ArrayList<Integer> imageListId = new ArrayList<Integer>();

        Field[] drawables = R.drawable.class.getFields();
        for (Field f : drawables) {
            if (f.getName().contains("f_")) {
                imageListId.add(getResources().getIdentifier(f.getName(), "drawable", getPackageName()));
            }
        }
            for (int i = 0; i < divisas.length; i++) {
                listaDivisas.add(new ModeloDivisas(divisas[i], Float.parseFloat(valores[i]), ResourcesCompat.getDrawable(getResources(), imageListId.get(i), null)));
            }
        }
    }
