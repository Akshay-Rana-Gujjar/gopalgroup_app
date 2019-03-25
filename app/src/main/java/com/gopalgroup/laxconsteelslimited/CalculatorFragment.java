package com.gopalgroup.laxconsteelslimited;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CalculatorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculor, null);

        ListView listView = view.findViewById(R.id.calculator_list);

        String[] calculatorListItems = getResources().getStringArray(R.array.array_calculator);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.calculator_items_list, calculatorListItems);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);

                Intent intent = new Intent(getContext(), CalculatorActivity.class);
                intent.putExtra("calculator", value);
                startActivity(intent);



            }
        });

        return view;
    }



    float getRoundBarWeight(float diameter, float length){

        float roundBarDensity = 0.00617f;

        float formula = diameter * diameter * roundBarDensity * length;

        return formula;
    }
}
