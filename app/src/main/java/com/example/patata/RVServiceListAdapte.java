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

public class RVServiceListAdapte extends RecyclerView.Adapter<RVServiceListAdapte.ViewHolder>{
    Context context;
    ArrayList<ServiceList> serviceLists;
    public RVServiceListAdapte(Context context, ArrayList<ServiceList> arrayList) {
        this.context = context;
        this.serviceLists = arrayList;

    }

    @NonNull
    @Override
    public RVServiceListAdapte.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vf,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVServiceListAdapte.ViewHolder holder, int position) {
        //holder.b

    }

    @Override
    public int getItemCount() {
        return serviceLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView VFtxtMisionType,VFtxtTier,VFtxtNode,VFtxtEnemyLevel,VFexpiryTime;
        ImageView VFimgFaction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            VFimgFaction = itemView.findViewById(R.id.VFimgFaction);
            VFtxtMisionType = itemView.findViewById(R.id.VFtxtMisionType);
            VFtxtTier = itemView.findViewById(R.id.VFtxtTier);
            VFtxtNode = itemView.findViewById(R.id.VFtxtNode);
            VFtxtEnemyLevel = itemView.findViewById(R.id.VFtxtEnemyLevel);
            VFexpiryTime = itemView.findViewById(R.id.VFexpiryTime);

        }
        public void bind(ServiceList serviceList){
            VFtxtMisionType.setText(serviceList.getMissionType());
            VFtxtTier.setText(serviceList.getTier());
            VFtxtNode.setText(serviceList.getNode());
            VFtxtEnemyLevel.setText(serviceList.getEnemyKey());
            VFexpiryTime.setText(serviceList.getExpired());


        }
    }
}
