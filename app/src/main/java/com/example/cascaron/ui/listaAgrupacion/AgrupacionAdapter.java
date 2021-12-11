package com.example.cascaron.ui.listaAgrupacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.cascaron.R;
import com.example.cascaron.model.Agrupacion;
import com.example.cascaron.model.AgrupacionComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgrupacionAdapter extends RecyclerView.Adapter<AgrupacionAdapter.ViewHolder>{

    private final ArrayList<Agrupacion> list;
    private final OnManageAgrupacionListener listener;

    public AgrupacionAdapter(ArrayList<Agrupacion> list, OnManageAgrupacionListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AgrupacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agrupacion_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgrupacionAdapter.ViewHolder holder, int position) {
//Colores del tema material design
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
        return list.size();
    }

    public void update(List<Agrupacion> list) {
        this.list.clear();
        this.list.addAll(list);

        //ERROR DE QUE NO ACTUALIZA
        notifyDataSetChanged();
    }

    public void delete(Agrupacion deleted) {
        list.remove(deleted);
        notifyDataSetChanged();
    }

    /**
     * Ordena la vista en BASE AL METODO COMPARETO DEFINIDA EN EL POJO
     * (en este caso ordena por nombre)
     */
    public void order() {
        Collections.sort(list);
        notifyDataSetChanged();
    }

    public void inverseOrder(){
        Collections.reverse(list);
        notifyDataSetChanged();
    }

    /**
     * Ordena la vista en base a un objeto de una clase que implementa la interfaz
     * comparator
     */
    public void orderByDescription() {
        Collections.sort(list, new AgrupacionComparator());
        notifyDataSetChanged();
    }

    public void undo(Agrupacion deleted) {
        list.add(deleted);
        notifyDataSetChanged();
    }

    public interface OnManageAgrupacionListener {
        //Si se hace click en una dependencia se edita (onClickListener)
        void onEditAgrupacion(Agrupacion agrupacion);

        //Si se hace una pulsacion larga en la dependencia se elimina (onLongClickListener)
        void onDeleteAgrupacion(Agrupacion agrupacion);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            icon = itemView.findViewById(R.id.icon);
        }

        /**
         * Todos los metodos que se crean en la clase ViewHolder tienen acceso al elemento
         * View que contienen en la variable itemView
         *
         * @param agrupacion
         * @param listener
         */
        public void bind(Agrupacion agrupacion, OnManageAgrupacionListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), tvName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
