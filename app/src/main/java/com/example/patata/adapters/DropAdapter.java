package com.example.patata.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.R;
import com.example.patata.models.Drop;

import java.util.List;

public class DropAdapter extends RecyclerView.Adapter<DropAdapter.DropViewHolder> {

    private List<Drop> drops;

    public DropAdapter(List<Drop> drops) {
        this.drops = drops;
    }

    @NonNull
    @Override
    public DropViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drop, parent, false);
        return new DropViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DropViewHolder holder, int position) {
        Drop drop = drops.get(position);
        holder.place.setText(drop.getPlace());
        holder.item.setText(drop.getItem());
        holder.rarity.setText(drop.getRarity());
        holder.chance.setText(String.valueOf(drop.getChance()));
    }

    @Override
    public int getItemCount() {
        return drops.size();
    }

    static class DropViewHolder extends RecyclerView.ViewHolder {
        TextView place, item, rarity, chance;

        public DropViewHolder(@NonNull View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.place);
            item = itemView.findViewById(R.id.item);
            rarity = itemView.findViewById(R.id.rarity);
            chance = itemView.findViewById(R.id.chance);
        }
    }
    public void filterList(List<Drop> filteredDrops) {
        this.drops = filteredDrops;
        notifyDataSetChanged();
    }

}
