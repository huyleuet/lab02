package com.example.lab2.ui.messages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.data.StaticConfig;
import com.example.lab2.model.Conservation;
import com.example.lab2.model.Message;
import com.example.lab2.ui.chat.ChatActivity;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment implements ConservationsAdapter.Callback {

    private MessagesViewModel messagesViewModel;
    private RecyclerView messageRv;
    private List<Conservation> conservationList;
    private ConservationsAdapter conservationsAdapter;
    private String fakeMessage = "Programming in the large generally refers to the high-level state transition" +
            " interactions of a process. BPEL refers to this concept as an Abstract Process. " +
            "A BPEL Abstract Process represents a set of publicly observable behaviors in a standardized fashion";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_messages, container, false);
        messageRv = root.findViewById(R.id.message_rv);
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(StaticConfig.UID, "Huy", "Hello how are yoU? What is your name?", "5pm"));
        messageList.add(new Message(StaticConfig.UID, "Huy", "Hello how are you?", "5pm"));
        messageList.add(new Message("1", "Nam", fakeMessage, "5pm"));
        messageList.add(new Message("1", "Nam", "Hello how are you?", "5pm"));
        messageList.add(new Message(StaticConfig.UID, "Huy", "Hello how are you?", "5pm"));
        conservationList = new ArrayList<>();
        conservationList.add(new Conservation("Huy", messageList));
        conservationList.add(new Conservation("Nam", messageList));
        conservationList.add(new Conservation("Thanh", messageList));
        conservationList.add(new Conservation("Chien", messageList));
        conservationsAdapter = new ConservationsAdapter(conservationList, this);
        messageRv.setLayoutManager(new LinearLayoutManager(root.getContext(), RecyclerView.VERTICAL, false));
        messageRv.setAdapter(conservationsAdapter);
        return root;
    }

    @Override
    public void onItemClicked(int position) {
        Conservation conservation = conservationList.get(position);
        Bundle extras = new Bundle();
        extras.putParcelable("Conservation", conservation);
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
