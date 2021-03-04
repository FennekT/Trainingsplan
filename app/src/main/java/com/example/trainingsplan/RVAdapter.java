package com.example.trainingsplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlanViewHolder>{

    List<Trainingsplan> trainingsplan;

    RVAdapter(List<Trainingsplan> trainingsplanList){
        this.trainingsplan = trainingsplanList;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PlanViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
        planViewHolder.bindTo(trainingsplan.get(i));
    }

    @Override
    public int getItemCount() {
        return trainingsplan.size();
    }
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;

        PlanViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.trainingsplan_card, parent, false));
            tv = itemView.findViewById(R.id.textView);
        }

        public void bindTo(Trainingsplan trainingsplan) {
            tv.setText(trainingsplan.name);
        }
    }

}