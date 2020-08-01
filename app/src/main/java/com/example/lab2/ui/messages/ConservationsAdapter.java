package com.example.lab2.ui.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.model.Conservation;
import com.example.lab2.model.Message;

import java.util.List;

public class ConservationsAdapter extends RecyclerView.Adapter<ConservationsAdapter.ConservationViewHolder> {
    private List<Conservation> conservationList;
    private Callback callBack;

    public ConservationsAdapter(List<Conservation> conservationList, Callback callBack) {
        this.conservationList = conservationList;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ConservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conservation_item, parent, false);
        return new ConservationsAdapter.ConservationViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConservationViewHolder holder, final int position) {
        Conservation conservation = conservationList.get(position);
        List<Message> messageList = conservation.getMessageList();
        holder.contactName.setText(conservation.getContactName());
        holder.recentMessage.setText(messageList.get(messageList.size() - 1).getContent());
        holder.time.setText(messageList.get(messageList.size() - 1).getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return conservationList != null ? conservationList.size() : 0;
    }

    public static class ConservationViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private TextView recentMessage;
        private TextView time;

        public ConservationViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            recentMessage = itemView.findViewById(R.id.recent_message);
            time = itemView.findViewById(R.id.time);
        }
    }

    public interface Callback {
        void onItemClicked(int position);
    }
}
