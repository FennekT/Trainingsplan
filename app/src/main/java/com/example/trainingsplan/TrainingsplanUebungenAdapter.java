package com.example.trainingsplan;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.example.trainingsplan.database.UebungenEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrainingsplanUebungenAdapter extends ListAdapter<UebungenEntity, TrainingsplanUebungenAdapter.UebungViewHolder> {

    Set<UebungenEntity> selectedSet = new HashSet<>();

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

    public Set<UebungenEntity> getSelectedEntities() {
        return selectedSet;
    }

    public class UebungViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final FloatingActionButton selectBtn;
        private final ImageView iv;
        private UebungenEntity boundEntity;

        UebungViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.uebungen_card, parent, false));
            tv = itemView.findViewById(R.id.uebung_titel);
            iv = itemView.findViewById(R.id.imageView);
            selectBtn = itemView.findViewById(R.id.floatingActionButton4);
            selectBtn.setVisibility(View.INVISIBLE);

            itemView.setOnLongClickListener(v -> {
              Intent intent = new Intent(itemView.getContext(), UebungenCreationActivity.class);
             intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, boundEntity);
             itemView.getContext().startActivity(intent);
                return false;
            });
            itemView.setOnClickListener(v -> {
                //  Intent intent = new Intent(itemView.getContext(), UebungenCreationActivity.class);
                //  intent.putExtra(UebungenCreationActivity.EXTRA_UEBUNG, boundEntity);
                // itemView.getContext().startActivity(intent);

                if (selectBtn.getVisibility() == View.VISIBLE) {
                    selectBtn.setVisibility(View.INVISIBLE);
                    selectedSet.remove(boundEntity);
                } else {
                    selectBtn.setVisibility(View.VISIBLE);
                    selectedSet.add(boundEntity);
                }

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