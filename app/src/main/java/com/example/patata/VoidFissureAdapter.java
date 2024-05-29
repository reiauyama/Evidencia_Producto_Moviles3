package com.example.patata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VoidFissureAdapter extends RecyclerView.Adapter<VoidFissureAdapter.ViewHolder> {

    private List<Fissure> fissures;

    public VoidFissureAdapter(List<Fissure> fissures) {
        this.fissures = fissures;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fissure, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fissure fissure = fissures.get(position);
        holder.node.setText(fissure.getNode());
        holder.missionType.setText(fissure.getMissionType());
        holder.enemy.setText(fissure.getEnemy());
        holder.tier.setText(fissure.getTier());
    }

    @Override
    public int getItemCount() {
        return fissures.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView node, missionType, enemy, tier;

        public ViewHolder(View itemView) {
            super(itemView);
            node = itemView.findViewById(R.id.node);
            missionType = itemView.findViewById(R.id.missionType);
            enemy = itemView.findViewById(R.id.enemy);
            tier = itemView.findViewById(R.id.tier);
        }
    }
}
