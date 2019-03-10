package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class Masterlistfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.fragment_master_list, container, false);
        MasterListAdapter masterListAdapter = new MasterListAdapter(getActivity(), AndroidImageAssets.getAll());
        GridView gridView = (GridView)rootview.findViewById(R.id.allimages);
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mcallback.onImageselected(position);
            }
        });
        return  rootview;
    }
    public interface OnImageClickListener{
        public  void onImageselected(int position);
    }
    OnImageClickListener mcallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mcallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }
    }
}

