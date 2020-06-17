package com.example.lab2.ui.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    private MatchesAdapter matchesAdapter;
    private MatchesViewModel matchesViewModel;
    private RecyclerView matchesRv;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_matches, container, false);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Huy", "Active now"));
        personList.add(new Person("Huy", "Active now"));
        personList.add(new Person("Huy", "Active now"));
        personList.add(new Person("Huy", "Active now"));
        personList.add(new Person("Huy", "Last seen 22 apr"));
        personList.add(new Person("Huy", "Active now"));
        matchesRv = root.findViewById(R.id.matchesRv);
        matchesRv.setHasFixedSize(true);
        matchesRv.setLayoutManager(new GridLayoutManager(root.getContext(),2));
        matchesAdapter = new MatchesAdapter(personList);
        matchesRv.setAdapter(matchesAdapter);
        return root;
    }

}