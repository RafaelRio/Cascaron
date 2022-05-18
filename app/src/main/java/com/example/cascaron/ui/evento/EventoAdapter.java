package com.example.cascaron.ui.evento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.cascaron.R;
import com.example.cascaron.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {
    private final List<Evento> list;
    EventoAdapter.OnManageEventoListener listener;

    public EventoAdapter(ArrayList<Evento> list, OnManageEventoListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public interface OnManageEventoListener {
        void onEditEvento(Evento evento);
        void onDeleteEvento(Evento evento);
    }

    public void update(List<Evento> list) {
        this.list.clear();
        this.list.addAll(list);

        //ERROR DE QUE NO ACTUALIZA
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder holder, int position) {
        ColorGenerator generator = ColorGenerator.MATERIAL;
        //Generar un color aleatorio
        int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .toUpperCase()
                .bold()
                .endConfig()
                .buildRound(list.get(position).getNombre().substring(0, 1), color);

        holder.icon.setImageDrawable(drawable);

        //Cuando se actualiza la lista se indica a la clase holder que dependencia es y cual es su listener
        holder.bind(list.get(position), listener);
        holder.tvName.setText(list.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            icon = itemView.findViewById(R.id.icon);
        }

        public void bind(Evento evento, OnManageEventoListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEditEvento(evento);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onDeleteEvento(evento);
                    return true;
                }
            });
        }
    }
}
