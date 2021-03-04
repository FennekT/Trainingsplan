package com.example.trainingsplan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.trainingsplan.database.TrainingsplanDatabase;
import com.example.trainingsplan.database.TrainingsplanEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateTrainingsplanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateTrainingsplanFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateTrainingsplanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateTrainingsplanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateTrainingsplanFragment newInstance(String param1, String param2) {
        CreateTrainingsplanFragment fragment = new CreateTrainingsplanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Button createButton = getView().findViewById(R.id.createButton);
        createButton.setOnClickListener(this::onClick);
        Button abortButton = getView().findViewById(R.id.abortButton);
        abortButton.setOnClickListener(this::onClick);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_trainingsplan, container, false);
    }

    @Override
    public void onClick(View v) {
        //Trainingsplan erstellen wenn Button Erstellen gedrueckt wird
        if (v.getId() == R.id.createButton){
            TrainingsplanDatabase.getInstance(v.getContext())
                    .getTrainingsplanDAO()
                    .addTrainingsplan(new TrainingsplanEntity());
        }
        //Fragment wieder schliessen wenn Button Abbrechen gedrueckt wird
        if (v.getId() == R.id.abortButton){
            getActivity().getFragmentManager().popBackStack();
        }
    }
}