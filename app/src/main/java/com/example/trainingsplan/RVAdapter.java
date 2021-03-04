package com.example.trainingsplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanEntity;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlanViewHolder> {

    List<TrainingsplanEntity> trainingsplanEntities;

    RVAdapter(List<TrainingsplanEntity> trainingsplanEntities) {
        this.trainingsplanEntities = trainingsplanEntities;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PlanViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
        planViewHolder.bindTo(trainingsplanEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return trainingsplanEntities.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final ImageView iv;

        PlanViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.trainingsplan_card, parent, false));
            tv = itemView.findViewById(R.id.textView);
            iv = itemView.findViewById(R.id.imageView);
        }

        public void bindTo(TrainingsplanEntity trainingsplanEntity) {
            tv.setText(trainingsplanEntity.getTrainingsplanTitle());
            //TODO: image id zu Trainingsplan Entity hinzufuegen
            //iv.setImageResource(trainingsplanEntity.image);

        }
    }

}