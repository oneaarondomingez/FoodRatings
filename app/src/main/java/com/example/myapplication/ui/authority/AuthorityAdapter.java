package com.example.myapplication.ui.authority;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by user on 3/30/17.
 */

public class AuthorityAdapter extends RecyclerView.Adapter<AuthorityAdapter.ViewHolder> {
    private TreeMap<String, Double> mapFrequencies;
    private List<String> scores;

    public AuthorityAdapter(TreeMap<String, Double> mapFrequencies) {
        this.mapFrequencies = mapFrequencies;

        scores = new ArrayList<>(new TreeSet<>(mapFrequencies.keySet()));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_establishment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String score = scores.get(position);
        holder.bind(score, mapFrequencies.get(score));
    }

    @Override
    public int getItemCount() {
        scores = new ArrayList<>(new TreeSet<>(mapFrequencies.keySet()));
        return mapFrequencies != null
                ? mapFrequencies.size()
                : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.r_establishment_text);
        }

        public void bind(String score, Double average) {
            textView.setText(String.format(Locale.getDefault(), "%s : %.2f%%", score, average * 100));
        }
    }
}
