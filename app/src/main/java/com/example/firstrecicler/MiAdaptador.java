package com.example.firstrecicler;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    Context context;
    private ArrayList<ModeloDivisas> listaDivisas;

    public MiAdaptador(Context context, ArrayList<ModeloDivisas> listaDivisas) {
        this.context = context;
        this.listaDivisas = listaDivisas;
    }

    @NonNull
    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {
        holder.divisa.setText(listaDivisas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listaDivisas.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView divisa;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            divisa = itemView.findViewById(R.id.divisa);
        }
    }
}
