package com.example.pruebarecyclerview.clases;


import android.os.Parcel;
import android.os.Parcelable;

public class Origin implements Parcelable {
    private String name;
    private String url;

    // Getters y Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected Origin(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Origin> CREATOR = new Creator<Origin>() {
        @Override
        public Origin createFromParcel(Parcel in) {
            return new Origin(in);
        }

        @Override
        public Origin[] newArray(int size) {
            return new Origin[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}