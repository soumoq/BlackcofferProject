package com.example.signin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CardViewClass extends ArrayAdapter<String> {
    final Activity context;
    final String[] saved_name;


    public CardViewClass(@NonNull Activity context, String[] saved_name) {
        super(context, R.layout.saved_list_view, saved_name);
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
