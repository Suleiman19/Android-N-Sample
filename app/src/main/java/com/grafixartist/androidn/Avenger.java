package com.grafixartist.androidn;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * AndroidN
 * Created by Suleiman19 on 5/14/16.
 * Copyright (c) 2016. Suleiman Ali Shakir. All rights reserved.
 */
public class Avenger implements Parcelable {

    private String name, photo;

    public Avenger() {
    }

    public Avenger(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    protected Avenger(Parcel in) {
        name = in.readString();
        photo = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


// Parcelable Methods

    public static final Creator<Avenger> CREATOR = new Creator<Avenger>() {
        @Override
        public Avenger createFromParcel(Parcel in) {
            return new Avenger(in);
        }

        @Override
        public Avenger[] newArray(int size) {
            return new Avenger[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(photo);
    }
}
