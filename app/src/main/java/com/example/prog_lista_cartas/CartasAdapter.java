package com.example.prog_lista_cartas;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

// Adaptador personalizado para RecyclerView que muestra una lista de objetos Cartas
public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder> {
         // Lista de cartas que se mostrarán en el RecyclerView (ya filtradas)
        private ArrayList<Cartas> listaCartas;
        // Mapa que contiene los filtros aplicados (clave: tipo de carta, valor: si debe incluirse o no)
        private HashMap<String,Boolean> filtros;


    public CartasAdapter(ArrayList<Cartas> listaCartas, HashMap<String, Boolean> filtros, Context context) {
        this.listaCartas = new ArrayList<>();

        // Filtramos la lista de cartas usando los filtros
        for (int i = 0; i < listaCartas.size(); i++) {
            if (filtros.get(listaCartas.get(i).getTipo()) == true){
                this.listaCartas.add(listaCartas.get(i));
            }

        }

    }

        @NonNull
        @Override
        public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista, parent, false);
            return new CartasViewHolder(view);
        }
        // Vincula los datos de un objeto Carta con la vista correspondiente
        @Override
        public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {
            Cartas carta = listaCartas.get(position);
            holder.nombreTextView.setText(carta.getNombre());
            holder.tipoTextView.setText(carta.getTipo());

        }

        @Override
        public int getItemCount() {
            return this.listaCartas.size();
        }


        public static class CartasViewHolder extends RecyclerView.ViewHolder {
            // Referencias a los elementos de la interfaz en vista.xml
            TextView nombreTextView, tipoTextView;

            public CartasViewHolder(@NonNull View itemView) {
                super(itemView);
                nombreTextView = itemView.findViewById(R.id.nombre);
                tipoTextView = itemView.findViewById(R.id.tipo);
            }
        }
    }



