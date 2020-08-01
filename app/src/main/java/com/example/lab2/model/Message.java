package com.example.lab2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
    private String idSender;
    private String sender;
    private String content;
    private String time;

    public Message(String sender, String content, String time) {
        this.sender = sender;
        this.content = content;
        this.time = time;
    }

    public Message(String idSender, String sender, String content, String time) {
        this.idSender = idSender;
        this.sender = sender;
        this.content = content;
        this.time = time;
    }

    protected Message(Parcel parcel) {
        idSender = parcel.readString();
        sender = parcel.readString();
        content = parcel.readString();
        time = parcel.readString();
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public static final Creator<Message> CREATOR = new Creator<Message>()
    {
        @Override
        public Message createFromParcel(Parcel in)
        {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size)
        {
            return new Message[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idSender);
        parcel.writeString(sender);
        parcel.writeString(content);
        parcel.writeString(time);
    }
}
