package com.example.mylists.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Student implements Parcelable {
    private int mID;
    private String mFIO;
    private String mFaculty;
    private String mGroup;
    private ArrayList<Subject> mSubjects;

    public Student(int ID, String FIO, String faculty, String group) {
        mID= ID;
        mFIO = FIO;
        mFaculty = faculty;
        mGroup = group;
        mSubjects = new ArrayList<>();
    }

    protected Student(Parcel in) {
        mID= in.readInt();
        mFIO = in.readString();
        mFaculty = in.readString();
        mGroup = in.readString();
        mSubjects = in.createTypedArrayList(Subject.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeString(mFIO);
        dest.writeString(mFaculty);
        dest.writeString(mGroup);
        dest.writeTypedList(mSubjects);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    public int getID() {
        return mID;
    }

    public String getFIO() {
        return mFIO;
    }

    public String getFaculty() {
        return mFaculty;
    }

    public String getGroup() {
        return mGroup;
    }

    public void setFIO(String FIO) {
        mFIO = FIO;
    }

    public void setFaculty(String faculty) {
        mFaculty = faculty;
    }

    public void setGroup(String group) {
        mGroup = group;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        mSubjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return mSubjects;
    }

    public int addSubject(Subject subject){
        mSubjects.add(subject);
        return mSubjects.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "mID='" + mID + '\'' +
                "mFIO='" + mFIO + '\'' +
                ", mFaculty='" + mFaculty + '\'' +
                ", mGroup='" + mGroup + '\'' +
                '}';
    }

}
