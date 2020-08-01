package com.example.lab2.ui.chat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.CenterTitleToolbar;
import com.example.lab2.R;
import com.example.lab2.model.Conservation;

public class ChatActivity extends AppCompatActivity {
    CenterTitleToolbar toolbar;
    TextView titleTextView;
    RecyclerView messageRv;
    ListMessageAdapter listMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbar = findViewById(R.id.toolbar);
        titleTextView = findViewById(R.id.title);
        messageRv = findViewById(R.id.message_rv);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null && extras.containsKey("Conservation")) {
                Conservation conservation = extras.getParcelable("Conservation");
                if (conservation != null) {
                    if (getSupportActionBar() != null) {
                          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                          getSupportActionBar().setTitle(conservation.getContactName());
                    }
                    listMessageAdapter = new ListMessageAdapter(conservation);
                    messageRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                    messageRv.setAdapter(listMessageAdapter);
                }
            }
        }

    }
}
