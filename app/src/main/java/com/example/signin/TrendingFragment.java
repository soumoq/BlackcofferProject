package com.example.signin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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

import java.util.List;

public class TrendingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, container, false);

        String[] trending_title = {"# trending_title 1","# trending_title 2","# trending_title 3","# trending_title 1","# trending_title 2","# trending_title 3","# trending_title 1","# trending_title 2","# trending_title 3"};
        String[] trending_subtitle={"trending_subtitle 1","trending_subtitle 2","trending_subtitle 3","trending_subtitle 1","trending_subtitle 2","trending_subtitle 3","trending_subtitle 1","trending_subtitle 2","trending_subtitle 3"};

        ListView listView = view.findViewById(R.id.trending_list_view);
        MyListAdopter adapter = new MyListAdopter(getActivity(),trending_title , trending_subtitle);
        listView.setAdapter(adapter);

        return view;
    }
}


class MyListAdopter extends ArrayAdapter<String> {
    final Activity context;
    final String[] trending_title;
    final String[] trending_subtitle;


    public MyListAdopter(@NonNull Activity context, String[] trending_title, String[] trending_subtitle) {
        super(context, R.layout.trending_list_view, trending_title);
        this.context = context;
        this.trending_title = trending_title;
        this.trending_subtitle = trending_subtitle;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.trending_list_view, null, true);

        TextView trendingTitleTextView = rowView.findViewById(R.id.trending_title);
        TextView trendingSubtitleTextView = rowView.findViewById(R.id.trending_subtitle);

        trendingTitleTextView.setText(trending_title[position]);
        trendingSubtitleTextView.setText(trending_subtitle[position]);
        return rowView;

    }

}