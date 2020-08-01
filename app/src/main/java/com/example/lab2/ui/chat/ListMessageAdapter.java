package com.example.lab2.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.data.StaticConfig;
import com.example.lab2.model.Conservation;

public class ListMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_USER_MESSAGE = 0;
    public static final int VIEW_TYPE_FRIEND_MESSAGE = 1;
    private Conservation conservation;

    public ListMessageAdapter(Conservation conservation) {
        this.conservation = conservation;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FRIEND_MESSAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_friend, parent, false);
            return new ItemMessageFriendHolder(view);
        } else if (viewType == VIEW_TYPE_USER_MESSAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_user, parent, false);
            return new ItemMessageUserHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemMessageFriendHolder) {
            ((ItemMessageFriendHolder) holder).textContent.setText(conservation.getMessageList().get(position).getContent());
        } else if (holder instanceof ItemMessageUserHolder) {
            ((ItemMessageUserHolder) holder).textContent.setText(conservation.getMessageList().get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return conservation.getMessageList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return conservation.getMessageList().get(position).getIdSender().equals(StaticConfig.UID) ?
                VIEW_TYPE_USER_MESSAGE : VIEW_TYPE_FRIEND_MESSAGE;
    }

    public static class ItemMessageUserHolder extends RecyclerView.ViewHolder {
        private TextView textContent;

        public ItemMessageUserHolder(@NonNull View itemView) {
            super(itemView);
            textContent = itemView.findViewById(R.id.message_content);
        }
    }

    public static class ItemMessageFriendHolder extends RecyclerView.ViewHolder {
        private TextView textContent;

        public ItemMessageFriendHolder(@NonNull View itemView) {
            super(itemView);
            textContent = itemView.findViewById(R.id.message_content);

        }
    }
}
