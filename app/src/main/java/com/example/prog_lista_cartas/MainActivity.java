package com.example.prog_lista_cartas;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Cartas> listaCartas;
    HashMap<String, Boolean> filtros;
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


        //mensaje que figura como actualizacion de la lista de cartas
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "La lista se actualizó el 26/11/2024", Snackbar.LENGTH_LONG).show();
            }
        };

        //asociando los botones al listener
        ImageButton boton = findViewById(R.id.Btagua);
        boton.setOnClickListener(listener);

        ImageButton boton2 = findViewById(R.id.Btacero);
        boton2.setOnClickListener(listener);

        ImageButton boton3 = findViewById(R.id.Btelectrico);
        boton3.setOnClickListener(listener);

        ImageButton boton4 = findViewById(R.id.Btfuego);
        boton4.setOnClickListener(listener);

        ImageButton boton5 = findViewById(R.id.Btlucha);
        boton5.setOnClickListener(listener);

        ImageButton boton6 = findViewById(R.id.Btnormal);
        boton6.setOnClickListener(listener);

        ImageButton boton7 = findViewById(R.id.Btplanta);
        boton7.setOnClickListener(listener);

        ImageButton boton8 = findViewById(R.id.Btpsiquico);
        boton8.setOnClickListener(listener);

        ImageButton boton9 = findViewById(R.id.Btsiniestro);
        boton9.setOnClickListener(listener);

        ImageButton boton10 = findViewById(R.id.Bttierra);
        boton10.setOnClickListener(listener);


        // diccionario de filtros
        filtros = new HashMap<>();
        filtros.put("Eléctrico", false);
        filtros.put("Fuego", false);
        filtros.put("Planta", false);
        filtros.put("Lucha", false);
        filtros.put("Tierra", false);
        filtros.put("Siniestro", false);
        filtros.put("Psíquico", false);
        filtros.put("Agua", false);
        filtros.put("Acero", false);
        filtros.put("Normal", false);


        //array donde se almacenan las cartas
        listaCartas = new ArrayList<>();
        try {
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

            // si tenemos algun campo sin cubrir en el contnido saldra un mensaje en el Log informando del fallo
        } catch (NullPointerException | IllegalArgumentException e) {
            Log.e("Error", "Falta por cubrir un campo: " + e.getMessage());
        }

        CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, this);
        recyclerView.setAdapter(adaptador);

        //switch , asociando los filtros de tipo de carta para que figure al pulsar el switch segun el tipo
        listaagua = findViewById(R.id.listaagua);
        listaagua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Agua", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaacero = findViewById(R.id.listaacero);
        listaacero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Acero", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaelectrico = findViewById(R.id.listaelectrico);
        listaelectrico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Eléctrico", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listafuego = findViewById(R.id.listafuego);
        listafuego.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Fuego", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listalucha = findViewById(R.id.listalucha);
        listalucha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Lucha", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listanormal = findViewById(R.id.listanormal);
        listanormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Normal", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listapsiquico = findViewById(R.id.listapsiquico);
        listapsiquico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Psíquico", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listasiniestro = findViewById(R.id.listasiniestro);
        listasiniestro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Siniestro", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listatierra = findViewById(R.id.listatierra);
        listatierra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Tierra", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }
        });

        listaplanta = findViewById(R.id.listaplanta);
        listaplanta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                filtros.put("Planta", b);
                CartasAdapter adaptador = new CartasAdapter(listaCartas, filtros, MainActivity.this);
                recyclerView.setAdapter(adaptador);

            }

        });


        //Tablayout
        TabLayout tabLayout = findViewById(R.id.TabLayout);
        // Añadir pestañas
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Log.d("TabLayout", "Tab seleccionada: " + tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("POKEMETA");
        setSupportActionBar(toolbar);
        //habilitar el boton opciones
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView1=(TextView)findViewById(R.id.textView);
        //asociamos el textview al popup menu
        registerForContextMenu(textView1);
        //al pulsar
        textView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              showPopUpMenu(view);
            }
        });

    }

    //Menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // metodo de gestion de items del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        if (item.getItemId() == R.id.item1) {
            i = new Intent("android.intent.action.VIEW", Uri.parse("https://www.anipedia.net/gatos/"));
            startActivity(i);
        }
        return true;
    }

    //Menu pop flotante mateniedo pulsado
    // Método para asociar un menú emergente popup al pulsar el textView
    public void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.acciones, popupMenu.getMenu());
        // Manejador de clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                TextView tv;
                if (item.getItemId() == R.id.itemAmarillo) {
                    tv = (TextView) view;
                    tv.setTextColor(Color.YELLOW);
                }
                return true;
            }
        });
        // mostrarlo
        popupMenu.show();

    }
}