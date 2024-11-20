package com.example.prog_lista_cartas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
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
        filtros.put("Eléctrico",true);
        filtros.put("Fuego",true);
        filtros.put("Planta",true);
        filtros.put("Lucha",true);
        filtros.put("Tierra",true);
        filtros.put("Siniestro",true);
        filtros.put("Psíquico",true);
        filtros.put("Agua",true);
        filtros.put("Acero",true);
        filtros.put("Normal",true);


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



    }
}