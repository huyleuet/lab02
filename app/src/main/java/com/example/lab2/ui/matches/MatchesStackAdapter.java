package com.example.lab2.ui.matches;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.model.Profile;

import java.util.List;

public class MatchesStackAdapter extends RecyclerView.Adapter<MatchesStackAdapter.MatchesStackViewHolder> {
    private List<Profile> mProfileList;

    public MatchesStackAdapter(List<Profile> profileList) {
        mProfileList = profileList;
    }

    @NonNull
    @Override
    public MatchesStackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_profile, parent, false);
        return new MatchesStackAdapter.MatchesStackViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesStackViewHolder holder, int position) {
        Profile profile = mProfileList.get(position);
        holder.name.setText(profile.getName() + ", " + profile.getAge());
        holder.matchStatistic.setText(profile.getMatchStatistic() + " Matches");
        holder.location.setText(profile.getLocation());
        holder.description.setText(profile.getDescription());
    }

    @Override
    public int getItemCount() {
        return mProfileList != null ? mProfileList.size() : 0;
    }

    public static class MatchesStackViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private Button matchStatistic;
        private TextView location;
        private TextView description;

        public MatchesStackViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            matchStatistic = itemView.findViewById(R.id.matches_statistic);
            location = itemView.findViewById(R.id.location);
            description = itemView.findViewById(R.id.description);
        }
    }

}
