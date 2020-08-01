package com.example.lab2.ui.matches;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.model.User;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchesListViewHolder> {
    private List<User> personList;
    private Callback callBack;

    public MatchesAdapter(List<User> personList, Callback callBack) {
        this.personList = personList;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public MatchesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_item, parent, false);
        return new MatchesAdapter.MatchesListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesListViewHolder holder, final int position) {
        holder.name.setText(personList.get(position).getName());
        holder.onlineStatus.setText(personList.get(position).getOnlineStatus());
        if (personList.get(position).getOnlineStatus().equals("Active now"))
            holder.onlineImage.setVisibility(View.VISIBLE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList != null ? personList.size() : 0;
    }

    public static class MatchesListViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView onlineStatus;
        private ImageView onlineImage;
        public MatchesListViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            onlineStatus = view.findViewById(R.id.online_status);
            onlineImage = view.findViewById(R.id.online_image);
        }
    }
    public interface Callback {
        void onItemClicked(int position);
    }
}
