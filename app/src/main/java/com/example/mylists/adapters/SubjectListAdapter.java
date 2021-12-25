package com.example.mylists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mylists.R;
import com.example.mylists.models.Subject;

import java.util.ArrayList;

public class SubjectListAdapter extends BaseAdapter {
    ArrayList<Subject> mSubjects;
    Context mContext;
    LayoutInflater mInflater;

    public SubjectListAdapter(ArrayList<Subject> subjects, Context context) {
        mSubjects = subjects;
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mSubjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mSubjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.subject_element, parent, false);
        if (mSubjects.isEmpty()) return convertView;

        ((TextView) convertView.findViewById(R.id.tvSubjestName)).setText(mSubjects.get(position).getName());
        ((TextView) convertView.findViewById(R.id.tvSubjectMark)).setText(mSubjects.get(position).getMark().toString());

        return convertView;
    }
}
