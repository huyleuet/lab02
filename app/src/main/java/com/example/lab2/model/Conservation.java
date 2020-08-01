package com.example.lab2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Conservation implements Parcelable {

    private String contactName;

    private List<Message> messageList;

    public Conservation(String contactName, List<Message> messageList) {
        this.contactName = contactName;
        this.messageList = messageList;
    }

    protected Conservation(Parcel in) {
        messageList = new ArrayList<>();
        contactName = in.readString();
        messageList = in.createTypedArrayList(Message.CREATOR);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(contactName);
        parcel.writeTypedList(messageList);
    }

    public static final Creator<Conservation> CREATOR = new Creator<Conservation>() {
        @Override
        public Conservation createFromParcel(Parcel in) {
            return new Conservation(in);
        }

        @Override
        public Conservation[] newArray(int size) {
            return new Conservation[size];
        }
    };
}
