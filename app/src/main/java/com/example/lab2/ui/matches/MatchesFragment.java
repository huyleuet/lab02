package com.example.lab2.ui.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.ItemOffsetDecoration;
import com.example.lab2.R;
import com.example.lab2.model.Profile;
import com.example.lab2.model.User;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.RewindAnimationSetting;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment implements MatchesAdapter.Callback {
    private MatchesAdapter matchesAdapter;
    private MatchesViewModel matchesViewModel;
    private RecyclerView matchesRv;
    private CardStackView cardStackView;
    private int layoutType;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_matches, container, false);
        List<User> personList = new ArrayList<>();
        List<Profile> profileList = new ArrayList<>();
        personList.add(new User("Huy0", "Active now"));
        personList.add(new User("Huy1", "Active now"));
        personList.add(new User("Huy2", "Active now"));
        personList.add(new User("Huy3", "Active now"));
        personList.add(new User("Huy4", "Last seen 22 apr"));
        personList.add(new User("Huy5", "Active now"));
        profileList.add(new Profile("Huy0", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 0"));
        profileList.add(new Profile("Huy1", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 1"));
        profileList.add(new Profile("Huy2", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 2"));
        profileList.add(new Profile("Huy3", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 3"));
        profileList.add(new Profile("Huy4", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 4"));
        profileList.add(new Profile("Huy5", 22, "Vinh Phuc. VN", "90%",
                "Xin chao toi la Huy so 5"));
        matchesRv = root.findViewById(R.id.matchesRv);
        matchesRv.setHasFixedSize(true);
        matchesRv.setLayoutManager(new GridLayoutManager(root.getContext(), 2));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(root.getContext(), R.dimen.item_offset);
        matchesRv.addItemDecoration(itemDecoration);
        matchesAdapter = new MatchesAdapter(personList, this);
        matchesRv.setAdapter(matchesAdapter);
        cardStackView = root.findViewById(R.id.stack_view);
        CardStackLayoutManager cardStackLayoutManager = new CardStackLayoutManager(root.getContext());
        RewindAnimationSetting setting = new RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new DecelerateInterpolator())
                .build();
        cardStackLayoutManager.setRewindAnimationSetting(setting);
        cardStackView.setAdapter(new MatchesStackAdapter(profileList));
        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.rewind();
        return root;
    }

    @Override
    public void onItemClicked(int position) {
        matchesRv.setVisibility(View.GONE);
        cardStackView.setVisibility(View.VISIBLE);
    }

}