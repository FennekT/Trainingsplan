package com.example.trainingsplan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;

public class TrainingsplanUebungenAdapter extends ListAdapter<UebungenEntity, TrainingsplanUebungenAdapter.UebungViewHolder> {

    TrainingsplanUebungenAdapter() {
        super(new DiffUtil.ItemCallback<UebungenEntity>() {
            @Override
            public boolean areItemsTheSame(@NonNull UebungenEntity oldItem, @NonNull UebungenEntity newItem) {
                return oldItem.getUebungId().equals(newItem.getUebungId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull UebungenEntity oldItem, @NonNull UebungenEntity newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public UebungViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UebungViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(UebungViewHolder uebungViewHolder, int i) {
        uebungViewHolder.bindTo(getItem(i));
    }

    public class UebungViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final ImageView iv;
        private UebungenEntity boundEntity;

        UebungViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.uebungen_card, parent, false));
            tv = itemView.findViewById(R.id.uebung_titel);
            iv = itemView.findViewById(R.id.imageView);
          //  itemView.setOnLongClickListener(v -> {


           // });
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), UebungenCreationActivity.class);
                intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, boundEntity);
                itemView.getContext().startActivity(intent);
            });
        }


        public void bindTo(UebungenEntity uebungenEntity) {
            this.boundEntity = uebungenEntity;
            tv.setText(uebungenEntity.getUebungName());
            //TODO: image id zu Trainingsplan Entity hinzufuegen BONUS AUFGABE
//            iv.setImageResource(trainingsplanEntity.image);

        }
    }

}