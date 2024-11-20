package com.example.prog_lista_cartas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder> {

        private ArrayList<Cartas> listaCartas;
        private HashMap<String,Boolean> filtros;


    public CartasAdapter(ArrayList<Cartas> listaCartas, HashMap<String, Boolean> filtros, MainActivity mainActivity) {
            this.listaCartas = listaCartas;
            this.filtros = filtros;
    }

        @NonNull
        @Override
        public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista, parent, false);
            return new CartasViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {
            Cartas carta = listaCartas.get(position);

            Boolean electrico = filtros.get("Eléctrico");
            Boolean fuego = filtros.get("Fuego");
            Boolean planta = filtros.get("Planta");
            Boolean lucha = filtros.get("Lucha");
            Boolean tierra = filtros.get("Tierra");
            Boolean siniestro = filtros.get("Siniestro");
            Boolean psíquico = filtros.get("Psíquico");
            Boolean agua = filtros.get("Agua");
            Boolean acero = filtros.get("Acero");
            Boolean normal = filtros.get("Normal");

            holder.nombreTextView.setText(carta.getNombre());
            holder.tipoTextView.setText(carta.getTipo());

        }

        @Override
        public int getItemCount() {
            return listaCartas.size();
        }


        public static class CartasViewHolder extends RecyclerView.ViewHolder {
            TextView nombreTextView, tipoTextView;

            public CartasViewHolder(@NonNull View itemView) {
                super(itemView);
                nombreTextView = itemView.findViewById(R.id.nombre);
                tipoTextView = itemView.findViewById(R.id.tipo);
            }
        }
    }



