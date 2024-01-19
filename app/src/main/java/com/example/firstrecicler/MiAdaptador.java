package com.example.firstrecicler;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    Context context;
    private ArrayList<ModeloDivisas> listaDivisas;
    ModeloDivisas selecDivisa;

    int posicionSelec = -1;
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
        final int pos = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicionSelec = pos;
                System.out.println(posicionSelec);
                notifyDataSetChanged();
            }
        });
        if (posicionSelec == position){
            holder.cardView.getBackground().setTint(Color.parseColor("#752bba"));
            selecDivisa = listaDivisas.get(position);
        }else{
            holder.cardView.getBackground().setTint(Color.parseColor("#494949"));
        }
    }

    @Override
    public int getItemCount() {
        return listaDivisas.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView divisa;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            divisa = itemView.findViewById(R.id.divisa);
            cardView = itemView.findViewById(R.id.cardDivisa);
        }
    }
}
