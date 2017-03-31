package com.example.myapplication.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.ratings.entities.authority.Authority;

import java.util.List;

/**
 * Created by user on 3/30/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<Authority> authorities;
    private MainOnClickListener mainOnClickListener;

    public MainAdapter(List<Authority> authorities, MainOnClickListener mainOnClickListener) {
        this.authorities = authorities;
        this.mainOnClickListener = mainOnClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_authority, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(authorities.get(position), mainOnClickListener);
    }

    @Override
    public int getItemCount() {
        return authorities != null
                ? authorities.size()
                : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.r_authority_text);
        }

        public void bind(final Authority authority, final MainOnClickListener mainOnClickListener) {
            itemView.setOnClickListener(view -> mainOnClickListener.onItemClick(authority));
            textView.setText(authority.getName());
        }
    }
}
