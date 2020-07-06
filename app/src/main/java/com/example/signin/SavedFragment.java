package com.example.signin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SavedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        String[] userName = {"Soumojyoti", "Ujjwal", "Shayan"};

        ListView listView = view.findViewById(R.id.saved_list_view);
        CardViewClass adapter = new CardViewClass(getActivity(), userName);
        listView.setAdapter(adapter);


        return view;
    }
}