package com.example.patata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VFListAdapter extends RecyclerView.Adapter<VFListAdapter.VFViewHolder> {
    Context context;
    ArrayList<ServiceList> VFServiceList;

    public VFListAdapter(Context context, ArrayList<ServiceList> VFServiceList) {
        this.context = context;
        this.VFServiceList = VFServiceList;
    }

    @NonNull
    @Override
    public VFViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_vf, parent, false);
        return new VFViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VFViewHolder holder, int position) {
        ServiceList serviceList = VFServiceList.get(position);
        holder.VFtxtMisionType.setText(serviceList.missionType);
        holder.VFtxtTier.setText(serviceList.tier);
        holder.VFtxtNode.setText(serviceList.node);
        holder.VFtxtEnemyLevel.setText(serviceList.tierNum);
        holder.VFexpiryTime.setText(serviceList.expired);

    }

    @Override
    public int getItemCount() {
        return VFServiceList.size() ;
    }

    public static class VFViewHolder extends RecyclerView.ViewHolder{
        TextView VFtxtMisionType,VFtxtTier,VFtxtNode,VFtxtEnemyLevel,VFexpiryTime;
        ImageView VFimgFaction;
      public VFViewHolder(@NonNull View itemView) {
          super(itemView);
          VFimgFaction = itemView.findViewById(R.id.VFimgFaction);
          VFtxtMisionType = itemView.findViewById(R.id.VFtxtMisionType);
          VFtxtTier = itemView.findViewById(R.id.VFtxtTier);
          VFtxtNode = itemView.findViewById(R.id.VFtxtNode);
          VFtxtEnemyLevel = itemView.findViewById(R.id.VFtxtEnemyLevel);
          VFexpiryTime = itemView.findViewById(R.id.VFexpiryTime);

      }
  }



}
