package com.example.mylists;

import com.example.mylists.models.Student;

import java.util.ArrayList;

public interface downloadFromDB {
    void onPostExecute(ArrayList<Student>... results);
}
