package com.example.patata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.R;
import com.example.patata.models.Alert;

import java.util.List;


// AlertAdapter.java
public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    private List<Alert> alertList;
    private Context context;

    public AlertAdapter(List<Alert> alertList, Context context) {
        this.alertList = alertList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alerts_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Alert alert = alertList.get(position);
        holder.description.setText(alert.getMission().getDescription());
        holder.node.setText(alert.getMission().getNode());
        holder.reward.setText(alert.getMission().getReward().getAsString());
    }

    @Override
    public int getItemCount() {
        return alertList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public TextView node;
        public TextView reward;

        public ViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            node = itemView.findViewById(R.id.node);
            reward = itemView.findViewById(R.id.reward);
        }
    }
}
