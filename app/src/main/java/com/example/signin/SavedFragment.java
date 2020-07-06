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

        String[] userName = {"Soumojyoti","Ujjwal","Shayan"};

        ListView listView = view.findViewById(R.id.saved_list_view);
        SavedListAdopter adapter = new SavedListAdopter(getActivity(), userName);
        listView.setAdapter(adapter);


        return view;
    }
}

class SavedListAdopter extends ArrayAdapter<String> {
    final Activity context;
    final String[] saved_name;


    public SavedListAdopter(@NonNull Activity context, String[] saved_name) {
        super(context, R.layout.saved_list_view,saved_name);
        this.context = context;
        this.saved_name = saved_name;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.saved_list_view, null, true);

        TextView savedNameTextView = rowView.findViewById(R.id.saved_username);
        savedNameTextView.setText(saved_name[position]);

        return rowView;
    }


}