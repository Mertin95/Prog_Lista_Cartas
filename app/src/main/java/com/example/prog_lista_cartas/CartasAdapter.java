package com.example.prog_lista_cartas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

    public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder> {

        private ArrayList<Cartas> listaCartas;




        @NonNull
        @Override
        public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista, parent, false);
            return new CartasViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {
            Cartas carta = listaCartas.get(position);
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



