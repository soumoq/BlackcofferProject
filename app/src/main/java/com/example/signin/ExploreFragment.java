package com.example.signin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExploreFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        String[] userName = {"Elon Musk", "Mark", "Rooney"};

        ListView listView = view.findViewById(R.id.explore_list_view);
        CardViewClass adapter = new CardViewClass(getActivity(), userName);
        listView.setAdapter(adapter);

        return view;
    }
}
