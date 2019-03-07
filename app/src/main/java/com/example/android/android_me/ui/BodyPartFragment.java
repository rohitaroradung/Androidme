package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
    private List<Integer> mImageIds;
    private int mListIndex;
    List<Integer> mlist;
    int mid;
    private static final String TAG = "BodyPartFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_body_part, container, false);
       final ImageView bodypart = (ImageView) rootview.findViewById(R.id.bodypart);

       if(mlist!=null) {
           bodypart.setImageResource(mlist.get(mid));
       }
       else
       {
           Log.v(TAG,"this has null value");
       }
        bodypart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mid<mlist.size()-1)
                    mid++;
                else
                    mid =0;
                bodypart.setImageResource(mlist.get(mid));
            }
        });
        return  rootview;

    }

    public void setMid(int mid) {
        if(mlist!=null)
        this.mid = mid;
    }

    public void setMlist(List<Integer> mlist) {
        this.mlist = mlist;
    }

    
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
