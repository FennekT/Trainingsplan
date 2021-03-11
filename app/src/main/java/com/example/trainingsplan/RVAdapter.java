package com.example.trainingsplan;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanEntity;

public class RVAdapter extends ListAdapter<TrainingsplanEntity, RVAdapter.PlanViewHolder> {

    RVAdapter() {
        super(new DiffUtil.ItemCallback<TrainingsplanEntity>() {
            @Override
            public boolean areItemsTheSame(@NonNull TrainingsplanEntity oldItem, @NonNull TrainingsplanEntity newItem) {
                return oldItem.getTrainingsplanId().equals(newItem.getTrainingsplanId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull TrainingsplanEntity oldItem, @NonNull TrainingsplanEntity newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PlanViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
        planViewHolder.bindTo(getItem(i));
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