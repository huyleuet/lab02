package com.example.lab2.ui.matches;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.model.Person;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchesListViewHolder> {
    private List<Person> personList;

    public MatchesAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public MatchesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_item, parent, false);
        return new MatchesAdapter.MatchesListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesListViewHolder holder, int position) {
        holder.name.setText(personList.get(position).getName());
        holder.onlineStatus.setText(personList.get(position).getOnlineStatus());
    }

    @Override
    public int getItemCount() {
        return personList != null ? personList.size() : 0;
    }

    public static class MatchesListViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView onlineStatus;

        public MatchesListViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            onlineStatus = view.findViewById(R.id.online_status);
        }

    }

}
