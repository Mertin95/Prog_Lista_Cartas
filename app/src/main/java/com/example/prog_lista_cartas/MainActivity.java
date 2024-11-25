package com.example.prog_lista_cartas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Cartas> listaCartas;
    HashMap<String,Boolean> filtros;
    private Switch listaagua;
    private Switch listaacero;
    private Switch listaelectrico;
    private Switch listafuego;
    private Switch listalucha;
    private Switch listanormal;
    private Switch listapsiquico;
    private Switch listasiniestro;
    private Switch listatierra;
    private Switch listaplanta;

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


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // diccionario de filtros
        filtros = new HashMap<>();
        filtros.put("Eléctrico",false);
        filtros.put("Fuego",false);
        filtros.put("Planta",false);
        filtros.put("Lucha",false);
        filtros.put("Tierra",false);
        filtros.put("Siniestro",false);
        filtros.put("Psíquico",false);
        filtros.put("Agua",false);
        filtros.put("Acero",false);
        filtros.put("Normal",false);



        listaCartas = new ArrayList<>();

        // Eléctrico
        listaCartas.add(new Cartas("Pikachu", "Eléctrico"));
        listaCartas.add(new Cartas("Electabuzz", "Eléctrico"));
        listaCartas.add(new Cartas("Raichu", "Eléctrico"));
        listaCartas.add(new Cartas("Jolteon", "Eléctrico"));
        listaCartas.add(new Cartas("Magnezone", "Eléctrico"));

        // Fuego
        listaCartas.add(new Cartas("Charmander", "Fuego"));
        listaCartas.add(new Cartas("Vulpix", "Fuego"));
        listaCartas.add(new Cartas("Growlithe", "Fuego"));
        listaCartas.add(new Cartas("Flareon", "Fuego"));
        listaCartas.add(new Cartas("Arcanine", "Fuego"));

        // Planta
        listaCartas.add(new Cartas("Bulbasaur", "Planta"));
        listaCartas.add(new Cartas("Oddish", "Planta"));
        listaCartas.add(new Cartas("Chikorita", "Planta"));
        listaCartas.add(new Cartas("Leafeon", "Planta"));
        listaCartas.add(new Cartas("Roserade", "Planta"));

        // Lucha
        listaCartas.add(new Cartas("Machop", "Lucha"));
        listaCartas.add(new Cartas("Hitmonlee", "Lucha"));
        listaCartas.add(new Cartas("Hitmonchan", "Lucha"));
        listaCartas.add(new Cartas("Lucario", "Lucha"));
        listaCartas.add(new Cartas("Conkeldurr", "Lucha"));

        // Tierra
        listaCartas.add(new Cartas("Sandshrew", "Tierra"));
        listaCartas.add(new Cartas("Cubone", "Tierra"));
        listaCartas.add(new Cartas("Diglett", "Tierra"));
        listaCartas.add(new Cartas("Groudon", "Tierra"));
        listaCartas.add(new Cartas("Mudbray", "Tierra"));

        // Siniestro
        listaCartas.add(new Cartas("Umbreon", "Siniestro"));
        listaCartas.add(new Cartas("Houndour", "Siniestro"));
        listaCartas.add(new Cartas("Sneasel", "Siniestro"));
        listaCartas.add(new Cartas("Zoroark", "Siniestro"));
        listaCartas.add(new Cartas("Honchkrow", "Siniestro"));

        // Psíquico
        listaCartas.add(new Cartas("Abra", "Psíquico"));
        listaCartas.add(new Cartas("Espeon", "Psíquico"));
        listaCartas.add(new Cartas("Mewtwo", "Psíquico"));
        listaCartas.add(new Cartas("Gardevoir", "Psíquico"));
        listaCartas.add(new Cartas("Metagross", "Psíquico"));

        // Agua
        listaCartas.add(new Cartas("Squirtle", "Agua"));
        listaCartas.add(new Cartas("Psyduck", "Agua"));
        listaCartas.add(new Cartas("Vaporeon", "Agua"));
        listaCartas.add(new Cartas("Lapras", "Agua"));
        listaCartas.add(new Cartas("Gyarados", "Agua"));

        // Acero
        listaCartas.add(new Cartas("Magnemite", "Acero"));
        listaCartas.add(new Cartas("Steelix", "Acero"));
        listaCartas.add(new Cartas("Skarmory", "Acero"));
        listaCartas.add(new Cartas("Metang", "Acero"));
        listaCartas.add(new Cartas("Bisharp", "Acero"));

        // Normal
        listaCartas.add(new Cartas("Eevee", "Normal"));
        listaCartas.add(new Cartas("Snorlax", "Normal"));
        listaCartas.add(new Cartas("Pidgey", "Normal"));
        listaCartas.add(new Cartas("Meowth", "Normal"));
        listaCartas.add(new Cartas("Rattata", "Normal"));


        CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,this);
        recyclerView.setAdapter(adaptador);

        //switch

        listaagua = findViewById(R.id.listaagua);
        listaagua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Agua",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaacero = findViewById(R.id.listaacero);
        listaacero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Acero",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaelectrico = findViewById(R.id.listaelectrico);
        listaelectrico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Eléctrico",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listafuego = findViewById(R.id.listafuego);
        listafuego.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Fuego",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listalucha = findViewById(R.id.listalucha);
        listalucha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Lucha",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listanormal = findViewById(R.id.listanormal);
        listanormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Normal",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listapsiquico = findViewById(R.id.listapsiquico);
        listapsiquico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Psíquico",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listasiniestro = findViewById(R.id.listasiniestro);
        listasiniestro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Siniestro",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listatierra = findViewById(R.id.listatierra);
        listatierra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Tierra",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaplanta = findViewById(R.id.listaplanta);
        listaplanta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Planta",b);
                CartasAdapter adaptador = new CartasAdapter (listaCartas, filtros,MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });



    }
}