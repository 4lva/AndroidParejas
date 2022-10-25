package com.example.parejas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;
    ImageButton ib4;
    ImageButton ib5;
    ImageButton ib6;
    Button reiniciar;
    //imagenes y array donde se almacenaran
    int dorab = R.drawable.dorab;
    int doray = R.drawable.doray;
    int dorao = R.drawable.dorao;
    ArrayList<Integer> fotos = new ArrayList<Integer>();
    //controlador del juego
    ImageButton ibd;
    int ultimaFoto;
    int i = 0;
    int acabado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib1 = findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);
        ib3 = findViewById(R.id.ib3);
        ib4 = findViewById(R.id.ib4);
        ib5 = findViewById(R.id.ib5);
        ib6 = findViewById(R.id.ib6);
        reiniciar = findViewById(R.id.reiniciar);
        //añadimos las imagenes al array y barajamos
        fotos.add(dorab);
        fotos.add(dorab);
        fotos.add(doray);
        fotos.add(doray);
        fotos.add(dorao);
        fotos.add(dorao);
        Collections.shuffle(fotos);
    }

    public void rebootImg(View view) {
        //reiniciamos
        recreate();
    }

    public void cambiaImg(View view) {
        //asignamos la imagen al boton
        if (view.getId() == ib1.getId()) {
            ib1.setImageResource(fotos.get(0));
            jugar(ib1,fotos.get(0));
        }
        if (view.getId() == ib2.getId()) {
            ib2.setImageResource(fotos.get(1));
            jugar(ib2,fotos.get(1));
        }
        if (view.getId() == ib3.getId()) {
            ib3.setImageResource(fotos.get(2));
            jugar(ib3,fotos.get(2));
        }
        if (view.getId() == ib4.getId()) {
            ib4.setImageResource(fotos.get(3));
            jugar(ib4,fotos.get(3));
        }
        if (view.getId() == ib5.getId()) {
            ib5.setImageResource(fotos.get(4));
            jugar(ib5,fotos.get(4));
        }
        if (view.getId() == ib6.getId()) {
            ib6.setImageResource(fotos.get(5));
            jugar(ib6,fotos.get(5));
        }
    }

    public void jugar(ImageButton iibb,int fotoo) {
        //controlamos la logica del programa donde mantendremos las fotos correctas o la ultima dada
        if(acabado!=3) {
            if (i == 0) {
                ibd = iibb;
                ultimaFoto = fotoo;
                i++;
            } else if (i == 1) {
                if (ultimaFoto == fotoo) {
                    i = 0;
                    acabado++;
                } else {
                    ibd.setImageResource(R.drawable.posterior);
                    ibd = iibb;
                    ultimaFoto = fotoo;
                }
            }
        }
    }
}