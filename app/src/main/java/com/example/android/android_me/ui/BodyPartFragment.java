package com.example.android.android_me.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {
    List<Integer> mlist = AndroidImageAssets.getHeads();
    int mid;
    private static final String TAG = "BodyPartFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView bodypart = (ImageView) rootview.findViewById(R.id.bodypart);
       if(mlist!=null) {
           bodypart.setImageResource(mlist.get(mid));
       }
       else
       {
           Log.v(TAG,"this has null value");
       }
        return  rootview;

    }

    public void setMid(int mid) {
        if(mlist!=null)
        this.mid = mid;
    }

    public void setMlist(List<Integer> mlist) {
        this.mlist = mlist;
    }
}
