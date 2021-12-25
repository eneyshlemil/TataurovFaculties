package com.example.mylists.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {
    Integer mID;
    Integer mIDStudent;
    String mName;
    Integer mMark;

    public Integer getID() {
        return mID;
    }

    public Integer getIDStudent() {
        return mIDStudent;
    }

    public Subject(Integer Id, Integer IDStudent,String name, Integer mark) {
        mID = Id;
        mIDStudent = IDStudent;
        mName = name;
        mMark = mark;
    }

    public Subject(Integer IDStudent,String name, Integer mark) {
        mIDStudent = IDStudent;
        mName = name;
        mMark = mark;
    }

    protected Subject(Parcel in) {
        mIDStudent = in.readInt();
        mName = in.readString();
        if (in.readByte() == 0) {
            mMark = null;
        } else {
            mMark = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        if (mMark == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mMark);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    public void setName(String name) {
        mName = name;
    }

    public void setMark(Integer mark) {
        mMark = mark;
    }

    public String getName() {
        return mName;
    }

    public Integer getMark() {
        return mMark;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "mName='" + mName + '\'' +
                ", mMark=" + mMark +
                '}';
    }
}
