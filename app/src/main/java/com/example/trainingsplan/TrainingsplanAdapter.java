package com.example.trainingsplan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanWithUebungen;

/**
 * Dieser Adapter ist fuer die dynamische Anzeige aller Trainigsplaene im Recyclerview der
 * TrainigsplanActivity zustaendig.
 */
public class TrainingsplanAdapter extends ListAdapter<TrainingsplanWithUebungen, TrainingsplanAdapter.PlanViewHolder> {

    TrainingsplanAdapter() {
        super(new DiffUtil.ItemCallback<TrainingsplanWithUebungen>() {
            @Override
            public boolean areItemsTheSame(@NonNull TrainingsplanWithUebungen oldItem, @NonNull TrainingsplanWithUebungen newItem) {
                return oldItem.trainingsplanEntity.getTrainingsplanId().equals(newItem.trainingsplanEntity.getTrainingsplanId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull TrainingsplanWithUebungen oldItem, @NonNull TrainingsplanWithUebungen newItem) {
                return oldItem.trainingsplanEntity.equals(newItem.trainingsplanEntity);
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
        private TrainingsplanWithUebungen boundEntity;

        PlanViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.trainingsplan_card, parent, false));
            tv = itemView.findViewById(R.id.textView);
            iv = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), TrainingsplanUebungenActivity.class);
                intent.putExtra(TrainingsplanUebungenActivity.EXTRA_TRAININGSPLAN, boundEntity);
                itemView.getContext().startActivity(intent);
            });
        }


        public void bindTo(TrainingsplanWithUebungen trainingsplanEntity) {
            this.boundEntity = trainingsplanEntity;
            tv.setText(trainingsplanEntity.trainingsplanEntity.getTrainingsplanTitle());
            //TODO: image id zu Trainingsplan Entity hinzufuegen BONUS AUFGABE
//            iv.setImageResource(trainingsplanEntity.image);

        }
    }

}