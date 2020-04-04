package com.example.mhcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class TreatmentFragment extends Fragment {
   private  CardView anxiety,depression,insomia,phobia,schizophrenia,ocd;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anxiety = getView().findViewById(R.id.anxiety);
        depression = getView().findViewById(R.id.depression);
        insomia = getView().findViewById(R.id.insomia);
        phobia = getView().findViewById(R.id.phobia);
        schizophrenia = getView().findViewById(R.id.schizophrenia);
        ocd = getView().findViewById(R.id.ocd);

        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Anxiety.class);
                startActivity(intent);

            }
        });
        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Depression.class);
                startActivity(intent);

            }
        });
        insomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Insomia.class);
                startActivity(intent);

            }
        });
        phobia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Phobia.class);
                startActivity(intent);

            }
        });
        schizophrenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Schizophrenia.class);
                startActivity(intent);

            }
        });
        ocd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),OCD.class);
                startActivity(intent);

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.treatment_fragment,container,false);

    }
}
